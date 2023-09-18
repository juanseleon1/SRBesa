package BESA.SocialRobot.InteractiveAgent.guard;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;

public class ConversationEventBundle {
    private UserEmotionalData emotionalData;
    private ConversationEventData conversationEventData;

    public ConversationEventBundle(UserEmotionalData emotionalData, ConversationEventData conversationEventData) {
        this.emotionalData = emotionalData;
        this.conversationEventData = conversationEventData;
    }

    public UserEmotionalData getEmotionalData() {
        return emotionalData;
    }

    public ConversationEventData getConversationEventData() {
        return conversationEventData;
    }

    public void setEmotionalData(UserEmotionalData emotionalData) {
        this.emotionalData = emotionalData;
    }

    public void setConversationEventData(ConversationEventData conversationEventData) {
        this.conversationEventData = conversationEventData;
    }

    public boolean hasEmotionalData() {
        return emotionalData != null;
    }
}
