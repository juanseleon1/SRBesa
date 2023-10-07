package BESA.SocialRobot.InteractiveAgent.guard;

import java.util.List;
import java.util.Map;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import rational.data.InfoData;


public class InteractionEventData extends InfoData {

    private InteractionEventTypes type;
    private Map<String, Object> data;
    private String userId;
    private boolean hasEmotionalData;
    private List<UserEmotion> emotions;

    public InteractionEventData(String userId, InteractionEventTypes type, Map<String, Object> data) {
        super(null);
        this.userId = userId;
        this.type = type;
        this.data = data;
        hasEmotionalData = false;
    }

    public InteractionEventData(String userId,InteractionEventTypes type, Map<String, Object> data, List<UserEmotion> emotions) {
        super(null);
        this.userId = userId;
        this.type = type;
        this.data = data;
        this.emotions = emotions;
        hasEmotionalData = true;
    }

    public InteractionEventTypes getType() {
        return type;
    }

    public void setType(InteractionEventTypes type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public boolean hasEmotionalData() {
        return hasEmotionalData;
    }

    public List<UserEmotion> getEmotions() {
        return emotions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "InteractionEventData [type=" + type + ", data=" + data + ", userId=" + userId + ", hasEmotionalData="
                + hasEmotionalData + ", emotions=" + emotions + "]";
    }

}
