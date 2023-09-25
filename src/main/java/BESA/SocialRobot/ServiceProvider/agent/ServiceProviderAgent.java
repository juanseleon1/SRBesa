package BESA.SocialRobot.ServiceProvider.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Social.ServiceProvider.agent.SPInfoGuard;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderAgentExceptionBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDescriptor;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.SyncActionGuard;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.agent.guard.ProcessRobotReplyGuard;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;
import rational.services.ActivateAsynchronousServiceGuard;

/**
 *
 * @author juans
 */
public class ServiceProviderAgent extends ServiceProviderBESA {

    protected ServiceProviderAgent(String alias, ServiceProviderState ssp)
            throws KernelAgentExceptionBESA {
        super(alias, ssp, getDefaultStruct(), 0.96);
    }

    public static StructBESA getDefaultStruct() {
        try {
            StructBESA struct = ServiceProviderBESA.getDefaultStruct();
            struct.addBehavior("BehaviorAsyncServiceProvider");
            struct.bindGuard("BehaviorAsyncServiceProvider", ActivateAsynchronousServiceGuard.class);
            struct.addBehavior("ProcessRobotReplyGuard");
            struct.bindGuard("ProcessRobotReplyGuard", ProcessRobotReplyGuard.class);
            return struct;
        } catch (ExceptionBESA ex) {
            ReportBESA.error(ex);
            return null;
        }
    }

    private static ServiceProviderState prepareServiceProvider(List<SRService<?>> services) {
        ServiceProviderState estado = null;
        try {
            ServiceProviderDescriptor spd = new ServiceProviderDescriptor();
            services.forEach(service -> {
                try {
                    spd.addSPService(service);
                } catch (ServiceProviderAgentExceptionBESA e) {
                    e.printStackTrace();
                }
            });
            estado = new ServiceProviderState(spd);
        } catch (Exception ex) {
            Logger.getLogger(ServiceProviderAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }

    @Override
    public void setupAgent() {
        ServiceProviderState ssp = (ServiceProviderState) this.getState();
        ssp.getDescriptor().getServiceAccessTable().forEach((string, service) -> {
            System.out.println("Registering service " + service.getName());
            this.getAdmLocal().bindSPServiceInDirectory(this.getAid(), service.getName());
        });
    }

    @Override
    public void shutdownAgent() {
    }

    public static ServiceProviderAgent buildServiceProviderAgent(String alias, List<SRService<?>> services)
            throws KernelAgentExceptionBESA {
        ServiceProviderAgent spa = new ServiceProviderAgent(alias, prepareServiceProvider(services));
        return spa;
    }

    public void processAsynchEvent(DataBESA data, String serviceName) {
        ServiceProviderState state = (ServiceProviderState) this.getState();
        Set<String> mySet = state.getAgentsGuardsTableAsync().keySet();
        for (String key : mySet) {
            ArrayList<SPInfoGuard> res = state.getAgentsGuardsTableAsync().get(key);
            for (int i = 0; i < res.size(); i++) {
                SPInfoGuard tmp = (SPInfoGuard) res.get(i);
                if (tmp.getServiceName().equals(serviceName) && tmp.getDataType().equals(data.getClass().getName())) {
                    // Devuelve el resultado de la ejeucion al agente solicitante
                    EventBESA evento = new EventBESA(tmp.getIdGuard(), data);
                    try {
                        this.getAdmLocal().getHandlerByAid(key).sendEvent(evento);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ReportBESA.error(e.toString());
                    }
                    break;
                }
            }
        }
    }

    public void sendActionConfirmation(RobotReplyData data) {
        try {
            AgHandlerBESA handler = this.getAdmLocal().getHandlerByAlias(ActionAgent.name);
            EventBESA event = new EventBESA(SyncActionGuard.class.getName(), data);
            handler.sendEvent(event);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
