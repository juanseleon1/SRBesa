
package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

import java.time.LocalDateTime;
import java.util.List;

import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class UserEmotionalData extends InfoData {
    private EmotionalDataType type;
    private List<UserEmotion> emotions;
    private LocalDateTime timestamp;
    private String userId;

    public UserEmotionalData(String userId, EmotionalDataType type, List<UserEmotion> emotions) {
        super("UserEmotionalData");
        this.type = type;
        this.emotions = emotions;
        this.timestamp = LocalDateTime.now();
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public EmotionalDataType getType() {
        return type;
    }

    public void setType(EmotionalDataType type) {
        this.type = type;
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

}
