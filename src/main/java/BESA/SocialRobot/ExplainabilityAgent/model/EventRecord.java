package BESA.SocialRobot.ExplainabilityAgent.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.RobotEmotions;

public class EventRecord {
    private EventRecordType type;
    private String userId;
    private Map<String, Double> userEmotions;
    private Map<RobotEmotions, Double> robotEmotions;
    private List<String> lastConversationRecord;
    private Map<String, String> lastQueries;
    private LocalDateTime date;
    private String intentionName;
    private String intentionType;
    private Map<String, Double> currentGoalInformation;
    private Map<String, Double> otherGoalInformation;

    public EventRecord(String userId, Map<String, Double> userEmotions, List<String> lastConversationRecord,
            Map<String, String> lastQueries) {
        this.type = EventRecordType.BELIEFS_USER;
        this.userId = userId;
        this.userEmotions = userEmotions;
        this.lastConversationRecord = lastConversationRecord;
        this.lastQueries = lastQueries;
        this.date = LocalDateTime.now();
    }

    public EventRecord(Map<RobotEmotions, Double> robotEmotions) {
        this.type = EventRecordType.BELIEFS_AGENT;
        this.robotEmotions = robotEmotions;
        this.date = LocalDateTime.now();
    }

    public EventRecord(String intentionName, String intentionType, Map<String, Double> currentGoalInformation,
            Map<String, Double> otherGoalInformation) {
        this.type = EventRecordType.GOALS;
        this.intentionName = intentionName;
        this.intentionType = intentionType;
        this.otherGoalInformation = otherGoalInformation;
        this.currentGoalInformation = currentGoalInformation;
        this.date = LocalDateTime.now();
    }

    public Map<String, Double> getCurrentGoalInformation() {
        return currentGoalInformation;
    }

    public Map<String, Double> getOtherGoalInformation() {
        return otherGoalInformation;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, Double> getUserEmotions() {
        return userEmotions;
    }

    public List<String> getLastConversationRecord() {
        return lastConversationRecord;
    }

    public Map<String, String> getLastQueries() {
        return lastQueries;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public EventRecordType getType() {
        return this.type;
    }

    public Map<RobotEmotions, Double> getRobotEmotions() {
        return robotEmotions;
    }

    public String getIntentionName() {
        return intentionName;
    }

    public String getIntentionType() {
        return intentionType;
    }

}
