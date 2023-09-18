package BESA.SocialRobot.HumanCooperationAgent.agent;

import BESA.Exception.ExceptionBESA;

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerData;
import BESA.SocialRobot.HumanCooperationAgent.guard.SHInteractionAnswerGuard;
import BESA.SocialRobot.HumanCooperationAgent.guard.SHInteractionRequestGuard;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
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
public class HumanCooperationAgent extends SRSupportAgent {
    public static String name = "HumanCooperationAgent";
    public static String interactionAnswerGuard = "interactionAnswerGuard";
    public static String permissionRequestGuard = "permissionRequestGuard";

    public HumanCooperationAgent() throws KernelAgentExceptionBESA {
        super(name, new HumanCooperationAgentState(), buildAgentStruct(), 0.96);
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior("interactionEventGuard");
            struct.bindGuard(interactionAnswerGuard, SHInteractionAnswerGuard.class);
            struct.bindGuard(permissionRequestGuard, SHInteractionRequestGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(HumanCooperationAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription<?, ?>> buildConfiguration() {
        AgentSubscription<InteractionAnswerData, SHInteractionAnswerGuard> messageSubscription = new AgentSubscription<>(
                ServiceNames.MESSAGE);
        AgentSubscription<InteractionAnswerData, SHInteractionAnswerGuard> mailSubscription = new AgentSubscription<>(
                ServiceNames.MAIL);
        AgentSubscription<InteractionAnswerData, SHInteractionAnswerGuard> tabletEvtSubscription = new AgentSubscription<>(
                ServiceNames.TABLETEVENT);
        List<AgentSubscription<?, ?>> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(messageSubscription);
        agSubscriptions.add(mailSubscription);
        agSubscriptions.add(tabletEvtSubscription);
        return agSubscriptions;
    }

}
