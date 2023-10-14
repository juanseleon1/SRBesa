package BESA.SocialRobot.InteractiveAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.ProcessRobotEmotionGuard;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterAgent;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.CalculateEmotionsGuard;
import rational.guards.InformationFlowGuard;
import BESA.Kernel.Agent.GuardBESA;


public class HumanInteractionEventGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        InteractiveAgentState state = (InteractiveAgentState) this.getAgent().getState();
        InteractionEventData data = (InteractionEventData) ebesa.getData();
        switch (data.getType()) {
            case TABLET:
            case TOUCH:
                EmotionalData emoData = state.processInterfaceInteraction(data);
                state.sendEventToAgent(emoData, ProcessRobotEmotionGuard.class, EmotionalInterpreterAgent.name);
                break;
            case VOICE:
                ConversationEventBundle bundle = state.processConversationEvent(data);
                if (bundle.hasEmotionalData()) {
                    state.sendEventToAgent(bundle.getEmotionalData(), CalculateEmotionsGuard.class,
                            UserEmotionalInterpreterAgent.name);
                }
                ConversationEventData convData = bundle.getConversationEventData();
                //ReportBESA.debug("Sending event to motivation agent"+convData);
                state.sendEventToAgent(convData, InformationFlowGuard.class,
                        MotivationAgent.name);
                if (convData.isQueryAnswer()) {
                    state.requestCompleted(convData.getOrigin());
                }
                break;
            default:
                break;
        }
    }

}
