
package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;
import rational.data.InfoData;
import rational.mapping.Believes;

public class ConversationContext implements Believes {
    private String userId;
    private Map<String, String> queries;
    private List<String> conversationRecord;
    private boolean isUserTalking;
    private boolean isRobotTalking;

    public boolean isUserTalking() {
        return isUserTalking;
    }

    public void setUserTalking(boolean isUserTalking) {
        this.isUserTalking = isUserTalking;
    }

    public ConversationContext() {
        queries = new HashMap<>();
        conversationRecord = new ArrayList<>();
    }

    public void addQuery(String key, String value) {
        queries.put(key, value);
    }

    public String getQueryResult(String key) {
        return queries.get(key);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean update(InfoData data) {
        boolean isUpdated = false;
        ConversationEventData conversationEventData = (ConversationEventData) data;
        if (conversationEventData.isQueryAnswer()) {
            addQuery(conversationEventData.getOrigin(), conversationEventData.getAnswer());
        } else {
            conversationRecord.add(conversationEventData.getMessage());
        }
        return isUpdated;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public List<String> getConversationRecord() {
        return conversationRecord;
    }

    public Map<String, String> getQueries() {
        return queries;
    }

    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }

    public void setConversationRecord(List<String> conversationRecord) {
        this.conversationRecord = conversationRecord;
    }

    public boolean isRobotTalking() {
        return isRobotTalking;
    }

    public void setRobotTalking(boolean isRobotTalking) {
        this.isRobotTalking = isRobotTalking;
    }

}
