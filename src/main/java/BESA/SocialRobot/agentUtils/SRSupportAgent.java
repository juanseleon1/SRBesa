package BESA.SocialRobot.agentUtils;

import java.util.List;

import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

public abstract class SRSupportAgent extends AgentBESA {
    public SRSupportAgent(String alias, StateBESA state, StructBESA structAgent, double passwd)
            throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }

    public abstract List<AgentSubscription> buildConfiguration();

    @Override
    public void setupAgent() {
        List<AgentSubscription> subs = this.buildConfiguration();
        ServiceUtils.subscribeServices(subs, this.getAid());
    }

    @Override
    public void shutdownAgent() {

    }

}
