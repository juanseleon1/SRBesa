package BESA.SocialRobot.UserEmotionalInterpreterAgent.model;

import java.time.LocalDateTime;
import java.util.List;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;

public class EmotionBundle {
    private List<UserEmotion> emotions;
    private LocalDateTime timestamp;

    public EmotionBundle(List<UserEmotion> emotions, LocalDateTime timestamp) {
        this.emotions = emotions;
        this.timestamp = timestamp;
    }

    public List<UserEmotion> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<UserEmotion> emotions) {
        this.emotions = emotions;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
