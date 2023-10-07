package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import rational.data.InfoData;
import rational.mapping.Believes;

public class UserInteractionState implements Believes {

    private Map<String, Double> userEmotions;
    private List<HistoricUserEmotions> historicUserEmotions;

    public UserInteractionState() {
        userEmotions = new ConcurrentHashMap<>();
        historicUserEmotions = new ArrayList<>();
    }

    public void addUserEmotion(String emotion, double intensity) {
        userEmotions.put(emotion, intensity);
    }

    public void removeUserEmotion(String emotion) {
        userEmotions.remove(emotion);
    }

    public void updateUserEmotion(String emotion, double intensity) {
        userEmotions.replace(emotion, intensity);
    }

    public Map<String, Double> getUserEmotions() {
        return userEmotions;
    }

    public void setUserEmotions(Map<String, Double> userEmotions) {
        this.userEmotions = userEmotions;
    }

    @Override
    public boolean update(InfoData data) {
        boolean isUpdated = false;
        UserEmotionalData emotionalData = (UserEmotionalData) data;
        List<UserEmotion> emotions = emotionalData.getEmotions();
        historicUserEmotions.add(new HistoricUserEmotions(emotions));
        for (UserEmotion emotion : emotions) {
            ReportBESA.debug("emotion name" + emotion.getName() + "emotion int" + emotion.getIntensity());
            if (!userEmotions.containsKey(emotion.getName())
                    || emotion.getIntensity() != userEmotions.get(emotion.getName())) {
                isUpdated = true;
                addUserEmotion(emotion.getName(), emotion.getIntensity());
            }
        }
        return isUpdated;
    }

    @Override
    public UserInteractionState clone() {
        UserInteractionState cloned = new UserInteractionState();
        cloned.userEmotions = new ConcurrentHashMap<>(userEmotions);
        return cloned;
    }
}
