
package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

import BESA.Log.ReportBESA;
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
        queries = new ConcurrentHashMap<>();
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
        //ReportBESA.debug("ConversationContext update Event sent to info: " + conversationEventData.getMessage());
        if (conversationEventData.isQueryAnswer()) {
            isUpdated = true;
            //ReportBESA.debug("Is query");
            addQuery(conversationEventData.getOrigin(), conversationEventData.getAnswer());
        } else {
            if (conversationEventData.getMessage() != null && !conversationEventData.getMessage().isEmpty()) {
                isUpdated = true;
                conversationRecord.add(conversationEventData.getMessage());
            }
        }
        if(conversationEventData.isRobotStatusSent()){
            isRobotTalking = conversationEventData.isRobotIsTalking();
        }
        return isUpdated;
    }

    @Override
    public ConversationContext clone() {
        ConversationContext cloned = new ConversationContext();
        cloned.queries = new ConcurrentHashMap<>(queries);
        cloned.conversationRecord = new ArrayList<>(conversationRecord);
        return cloned;
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

    public String getLastMessage() {
        String record = "";
        if (!conversationRecord.isEmpty()) {
            record = conversationRecord.get(conversationRecord.size() - 1);
        }
        return record;
    }

    @Override
    public String toString() {
        return "ConversationContext [userId=" + userId + ", queries=" + queries + ", conversationRecord="
                + conversationRecord + ", isUserTalking=" + isUserTalking + ", isRobotTalking=" + isRobotTalking + "]";
    }
}
