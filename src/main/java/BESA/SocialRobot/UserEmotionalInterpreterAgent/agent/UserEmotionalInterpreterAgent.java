package BESA.SocialRobot.UserEmotionalInterpreterAgent.agent;

import BESA.Exception.ExceptionBESA;

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.CalculateEmotionsGuard;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
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
public class UserEmotionalInterpreterAgent extends SRSupportAgent {
    public static String name = "UserEmotionalInterpreterAgent";
    public static String calculateEmotionsGuard = "CalculateEmotionsGuard";

    public UserEmotionalInterpreterAgent(UserEmotionalInterpreterState state) throws KernelAgentExceptionBESA {
        super(name, state, buildAgentStruct(), 0.96);
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior("CalculateEmotionsGuard");
            struct.bindGuard(calculateEmotionsGuard, CalculateEmotionsGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(UserEmotionalInterpreterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription> buildConfiguration() {
        AgentSubscription emotionalSubscription = new AgentSubscription(
                ServiceNames.EMOTIONEXTRACTOR, UserEmotionalData.class, CalculateEmotionsGuard.class);
        AgentSubscription videoSubscription = new AgentSubscription(
                ServiceNames.RAWVIDEO, UserEmotionalData.class, CalculateEmotionsGuard.class);

        List<AgentSubscription> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(emotionalSubscription);
        agSubscriptions.add(videoSubscription);

        return agSubscriptions;
    }

}
