package BESA.SocialRobot.InteractiveAgent.agent;

import BESA.Exception.ExceptionBESA;

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.InteractiveAgent.guard.HumanInteractionRequestGuard;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventGuard;
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
public class InteractiveAgent extends SRSupportAgent {
    public static String name = "InteractiveAgent";
    public static String interactionEventGuard = "InteractionEventGuard";
    public static String interactionRequestGuard = "interactionRequestGuard";

    public InteractiveAgent(InteractiveAgentState<?, ?> state) throws KernelAgentExceptionBESA {
        super(name, state, buildAgentStruct(), 0.96);
        System.out.println("SensorHandlerAgent Iniciado");
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior("interactionEventGuard");
            struct.bindGuard(interactionEventGuard, InteractionEventGuard.class);
            struct.addBehavior("interactionRequestGuard");
            struct.bindGuard(interactionRequestGuard, HumanInteractionRequestGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(InteractiveAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription<?, ?>> buildConfiguration() {
        AgentSubscription<InteractionEventData, InteractionEventGuard> interactionSubscription = new AgentSubscription<>(
                ServiceNames.SPEECHENGINE);
        List<AgentSubscription<?, ?>> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(interactionSubscription);
        return agSubscriptions;
    }
}
