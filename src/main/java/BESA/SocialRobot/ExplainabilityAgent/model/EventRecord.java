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
    private String pyramidSnapshot;
    private String latentGoalDescription;
    private String currentRole;

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

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

    public EventRecord(String intentionName, String intentionType, String pyramidSnapshot,
            String latentGoalDescription, String currentRole) {
        this.type = EventRecordType.GOALS;
        this.intentionName = intentionName;
        this.intentionType = intentionType;
        this.pyramidSnapshot = pyramidSnapshot;
        this.latentGoalDescription = latentGoalDescription;
        this.currentRole = currentRole;
        this.date = LocalDateTime.now();
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

    public void setType(EventRecordType type) {
        this.type = type;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserEmotions(Map<String, Double> userEmotions) {
        this.userEmotions = userEmotions;
    }

    public void setRobotEmotions(Map<RobotEmotions, Double> robotEmotions) {
        this.robotEmotions = robotEmotions;
    }

    public void setLastConversationRecord(List<String> lastConversationRecord) {
        this.lastConversationRecord = lastConversationRecord;
    }

    public void setLastQueries(Map<String, String> lastQueries) {
        this.lastQueries = lastQueries;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setIntentionName(String intentionName) {
        this.intentionName = intentionName;
    }

    public void setIntentionType(String intentionType) {
        this.intentionType = intentionType;
    }

    public String getPyramidSnapshot() {
        return pyramidSnapshot;
    }

    public void setPyramidSnapshot(String pyramidSnapshot) {
        this.pyramidSnapshot = pyramidSnapshot;
    }

    public String getLatentGoalDescription() {
        return latentGoalDescription;
    }

    public void setLatentGoalDescription(String latentGoalDescription) {
        this.latentGoalDescription = latentGoalDescription;
    }

}
