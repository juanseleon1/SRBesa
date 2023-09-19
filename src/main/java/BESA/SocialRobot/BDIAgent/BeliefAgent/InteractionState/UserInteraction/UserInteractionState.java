package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction;

import java.util.HashMap;
import java.util.Map;

public class UserInteractionState {

    private Map<String, Float> userEmotion;

    public UserInteractionState() {
        userEmotion = new HashMap<>();
    }

    //TODO: Add interface for emotion retrieval.

    public void addUserEmotion(String emotion, float intensity) {
        userEmotion.put(emotion, intensity);
    }

    public void removeUserEmotion(String emotion) {
        userEmotion.remove(emotion);
    }

    public void updateUserEmotion(String emotion, float intensity) {
        userEmotion.replace(emotion, intensity);
    }

    public Map<String, Float> getUserEmotion() {
        return userEmotion;
    }

    public void setUserEmotion(Map<String, Float> userEmotion) {
        this.userEmotion = userEmotion;
    }

}
