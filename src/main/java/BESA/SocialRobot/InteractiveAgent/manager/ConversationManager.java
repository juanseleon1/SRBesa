package BESA.SocialRobot.InteractiveAgent.manager;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventBundle;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.ServiceProvider.agent.ServiceRequestManager;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.EmotionalDataType;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;

public abstract class ConversationManager {

    public abstract String getAnswerFromText(PromptBuilder promptBuilder, String context, String text);

    public ConversationEventBundle processConversationEvent(PromptBuilder promptBuilder,
            ServiceRequestManager<String> manager, InteractionEventData data) {
        UserEmotionalData emotionalData = null;
        ConversationEventData conversationEventData = handleCustomEventData(data);
        conversationEventData.setUserId(data.getUserId());
        if (data.getData().containsKey("origin")) {
            String origin = (String) data.getData().get("origin");
            conversationEventData.setOrigin(origin);
            conversationEventData.setQueryId((int) data.getData().get("queryId"));
            String answer = getAnswerFromText(promptBuilder, origin,
                    (String) data.getData().get("text"));
            conversationEventData.setAnswer(answer);
            manager.requestCompleted(origin);
        } else {
            conversationEventData.setMessage((String) data.getData().get("text"));
        }
        if(data.getData().containsKey("robotIsTalking")){
            //ReportBESA.debug("CHECKING DATA IN CONVO MANAGER"+data.getData().get("robotIsTalking"));
            conversationEventData.setRobotStatusSent(true);
            conversationEventData.setRobotIsTalking((boolean) data.getData().get("robotIsTalking"));
        }

        if (data.hasEmotionalData()) {
            emotionalData = new UserEmotionalData(data.getUserId(), EmotionalDataType.VOICE, data.getEmotions());
        }
        return new ConversationEventBundle(emotionalData, conversationEventData);
    }

    public abstract ConversationEventData handleCustomEventData(InteractionEventData data);

}
