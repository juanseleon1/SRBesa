package BESA.SocialRobot.InteractiveAgent.guard;

import java.util.List;
import java.util.Map;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class InteractionEventData extends InfoData {

    private InteractionEventTypes type;
    private Map<String, ?> data;
    private float id;
    private boolean hasEmotionalData;
    private List<UserEmotion> emotions;

    public InteractionEventData(float id, InteractionEventTypes type, Map<String, ?> data) {
        super(null);
        this.type = type;
        this.data = data;
        hasEmotionalData = false;
    }

    public InteractionEventData(float id,InteractionEventTypes type, Map<String, ?> data, List<UserEmotion> emotions) {
        super(null);
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

    public Map<String, ?> getData() {
        return data;
    }

    public void setData(Map<String, ?> data) {
        this.data = data;
    }

    public boolean hasEmotionalData() {
        return hasEmotionalData;
    }

    public List<UserEmotion> getEmotions() {
        return emotions;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }
}
