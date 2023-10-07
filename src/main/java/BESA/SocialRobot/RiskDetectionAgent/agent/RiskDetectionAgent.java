package BESA.SocialRobot.RiskDetectionAgent.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.HumanCooperationAgent.agent.HumanCooperationAgent;
import BESA.SocialRobot.RiskDetectionAgent.guard.RiskDetectionGuard;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.SRSupportAgent;

public class RiskDetectionAgent extends SRSupportAgent {
    private static String riskDetectionGuard = "RiskDetectionGuard";
    private static String name = "RiskDetectionAgent";

    public RiskDetectionAgent(RiskDetectionAgentState state)
            throws KernelAgentExceptionBESA {
        super(name, state, buildAgentStruct(), 0.96);
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior(riskDetectionGuard);
            struct.bindGuard(riskDetectionGuard, RiskDetectionGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(HumanCooperationAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription> buildConfiguration() {
        AgentSubscription videoSubscription = new AgentSubscription(
                ServiceNames.RAWVIDEO, RawVideoData.class, RiskDetectionGuard.class);
        List<AgentSubscription> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(videoSubscription);
        return agSubscriptions;
    }

}
