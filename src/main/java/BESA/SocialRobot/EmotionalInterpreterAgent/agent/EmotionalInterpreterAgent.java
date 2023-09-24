
package BESA.SocialRobot.EmotionalInterpreterAgent.agent;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.ProcessRobotEmotionGuard;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.SRSupportAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class EmotionalInterpreterAgent extends SRSupportAgent {
    public static String name = "EmotionalInterpreterAgent";
    public static String ProcessEmotionGuard = "ProcessEmotionGuard";

    public EmotionalInterpreterAgent(EmotionalInterpreterStrategy eas) throws KernelAgentExceptionBESA {
        super(name, new EmotionalInterpreterState(eas), buildEAStruct(), 0.96);
    }

    private static StructBESA buildEAStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior(ProcessEmotionGuard);
            struct.bindGuard(ProcessEmotionGuard, ProcessRobotEmotionGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(EmotionalInterpreterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription> buildConfiguration() {
        List<AgentSubscription> agSubscriptions = new ArrayList<>();
        return agSubscriptions;
    }
}
