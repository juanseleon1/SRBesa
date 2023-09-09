package BESA.SocialRobot.ServiceProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderAgentExceptionBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDescriptor;
import BESA.Kernel.Social.ServiceProvider.agent.StateServiceProvider;
import BESA.Local.Directory.AgLocalHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.ServiceProvider.adapter.Adapter;
import rational.services.ActivateAsynchronousServiceGuard;

/**
 *
 * @author juans
 */
public class ServiceProviderAgent extends ServiceProviderBESA {

    private static AgLocalHandlerBESA agh;

    private Adapter adapter;

    private ServiceProviderAgent(String alias, Adapter adapter, StateServiceProvider ssp)
            throws KernelAgentExceptionBESA {
        super(alias, ssp, getDefaultStruct(), 0.96);
        this.adapter = adapter;
        //this.adapter.setRpa(this);
        System.out.println("RobotProviderAgent Iniciado");
    }

    public static StructBESA getDefaultStruct() {
        try {
            StructBESA struct = ServiceProviderBESA.getDefaultStruct();
            struct.addBehavior("BehaviorAsyncServiceProvider");
            struct.bindGuard("BehaviorAsyncServiceProvider", ActivateAsynchronousServiceGuard.class);
            return struct;
        } catch (ExceptionBESA ex) {
            ReportBESA.error(ex);
            return null;
        }
    }

    private static StateServiceProvider prepareServiceProvider(Adapter adapter) {
        StateServiceProvider estado = null;
        try {
            estado = new StateServiceProvider(adapter, buildProviderDescriptor());
        } catch (ServiceProviderAgentExceptionBESA ex) {
            Logger.getLogger(ServiceProviderAgent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceProviderAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }

    @Override
    public void setupAgent() {
        // TODO:If adapter is the receiver, bind to interested guards.
        // this.getAdmLocal().bindSPServiceInDirectory(this.getAid(), servActividades);
    }

    @Override
    public void shutdownAgent() {
    }

    private static ServiceProviderDescriptor buildProviderDescriptor() throws ServiceProviderAgentExceptionBESA {
        ServiceProviderDescriptor spd = new ServiceProviderDescriptor();
        // TODO: Determine when and how to build the descriptor.
        // ActivityService as= new ActivityService();
        // as.setName(servActividades);
        // spd.addSPService(as);

        return spd;
    }
}
