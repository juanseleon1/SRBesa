package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction;

import java.time.LocalDateTime;
import java.util.List;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;

public class HistoricUserEmotions {
    List<UserEmotion> emotions;
    private LocalDateTime date;

    public HistoricUserEmotions(List<UserEmotion> emotions) {
        this.emotions = emotions;
        this.date = LocalDateTime.now();
    }

    public List<UserEmotion> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<UserEmotion> emotions) {
        this.emotions = emotions;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
