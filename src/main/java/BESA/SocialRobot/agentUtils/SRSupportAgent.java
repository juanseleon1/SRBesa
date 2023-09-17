package BESA.SocialRobot.agentUtils;

import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Social.ServiceProvider.agent.GuardServiceProviderSuscribe;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDataSuscribe;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;

public abstract class SRSupportAgent extends AgentBESA {
    public SRSupportAgent(String alias, StateBESA state, StructBESA structAgent, double passwd)
            throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }

    public abstract List<AgentSubscription<?, ?>> buildConfiguration();

    @Override
    public void setupAgent() {
        List<AgentSubscription<?, ?>> subs = this.buildConfiguration();
        this.subscribeServices(subs);
    }

    @Override
    public void shutdownAgent() {

    }

    private void subscribeServices(List<AgentSubscription<?, ?>> subscriptions){
        subscriptions.forEach(suscription -> {

            try {
                String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(suscription.getServiceAgentId());
                AgHandlerBESA agH;
                agH = AdmBESA.getInstance().getHandlerByAid(spAgId);

                // Crea el data de suscripcion
                ServiceProviderDataSuscribe spDataSuscribe = new ServiceProviderDataSuscribe(
                        suscription.getGuardClassName(),
                        ServiceProviderBESA.ASYNCHRONIC_SERVICE,
                        suscription.getServiceAgentId(),
                        suscription.getDataClassName());
                // Crea el evento a enviar
                EventBESA evSP = new EventBESA(GuardServiceProviderSuscribe.class.getName(), spDataSuscribe);
                evSP.setSenderAgId(this.getAid());
                // Envia el evento
                agH.sendEvent(evSP);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }
        });
    }
}
