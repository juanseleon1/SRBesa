package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestEventRecordData;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import rational.data.InfoData;
import rational.mapping.Believes;

public class InteractionState implements Believes {
    private String activeService;
    private Map<String, ConversationContext> conversations;
    private Map<String, ServiceContext> serviceContexts;
    private Map<String, UserInteractionState> interactions;
    private RequestHandler requestHandler;
    private boolean requestedToExplain;
    private boolean recordsUpdated;
    private float userDistance;

    public InteractionState() {
        conversations = new ConcurrentHashMap<>();
        serviceContexts = new ConcurrentHashMap<>();
        interactions = new ConcurrentHashMap<>();
        requestHandler = new RequestHandler();
        requestedToExplain = false;
        recordsUpdated = false;

    }

    @Override
    public boolean update(InfoData data) {
        // ReportBESA.debug("JLEON13InteractionState update Event sent to info: " + data.getClass().getName());
        // ReportBESA.debug("data: " + data);
        boolean isUpdated = false;
        if (data instanceof UserEmotionalData) {
            UserEmotionalData emotionalData = (UserEmotionalData) data;
            isUpdated = getCurrentInteraction(emotionalData.getUserId()).update(emotionalData);
        } else if (data instanceof ConversationEventData) {
            ConversationEventData intData = (ConversationEventData) data;
            isUpdated = getCurrentConversation(intData.getUserId()).update(intData);
        } else if (data instanceof RequestEventRecordData) {
            requestedToExplain = true;
            isUpdated = true;
        } 
        if(activeService != null){
            isUpdated = getCurrentServiceContext().update(data) || isUpdated;
        }
        return isUpdated;
    }

    @Override
    public InteractionState clone() {
            InteractionState cloned = new InteractionState();
            cloned.setActiveService(this.getActiveService());
            cloned.conversations = new ConcurrentHashMap<>(conversations.size());
            for (Map.Entry<String, ConversationContext> entry : conversations.entrySet()) {
                cloned.conversations.put(entry.getKey(), entry.getValue().clone());
            }
            cloned.serviceContexts = new ConcurrentHashMap<>(serviceContexts.size());
            for (Map.Entry<String, ServiceContext> entry : serviceContexts.entrySet()) {
                cloned.serviceContexts.put(entry.getKey(), entry.getValue().clone());
            }
            cloned.interactions = new ConcurrentHashMap<>(interactions.size());
            for (Map.Entry<String, UserInteractionState> entry : interactions.entrySet()) {
                cloned.interactions.put(entry.getKey(), entry.getValue().clone());
            }
            return cloned;
    }

    public Map<String, ConversationContext> getConversations() {
        return conversations;
    }

    public void setConversations(Map<String, ConversationContext> conversations) {
        this.conversations = conversations;
    }

    public Map<String, ServiceContext> getServiceContexts() {
        return serviceContexts;
    }

    public void setServiceContexts(Map<String, ServiceContext> serviceContexts) {
        this.serviceContexts = serviceContexts;
    }

    public Map<String, UserInteractionState> getInteractions() {
        return interactions;
    }

    public void setInteractions(Map<String, UserInteractionState> interactions) {
        this.interactions = interactions;
    }

    public int getNumberOfPermissionsPending() {
        return requestHandler.getPendingRequestNumber();
    }

    public RequestHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public ServiceContext getCurrentServiceContext() {
        return serviceContexts.get(activeService);
    }

    public void setActiveService(String activeService) {
        this.activeService = activeService;
    }

    public String getActiveService() {
        return activeService;
    }

    public UserInteractionState getCurrentInteraction(String id) {
        if (!interactions.containsKey(id)) {
            interactions.put(id, new UserInteractionState());
        }
        return interactions.get(id);
    }

    public ConversationContext getCurrentConversation(String id) {
        //ReportBESA.debug("InteractionState getCurrentConversation: " + id);
        if (!conversations.containsKey(id)) {
            conversations.put(id, new ConversationContext());
        }
        return conversations.get(id);
    }

    public void addConversation(String id, ConversationContext context) {
        conversations.put(id, context);
    }

    public void addServiceContext(String id, ServiceContext context) {
        serviceContexts.put(id, context);
    }

    public void addInteraction(String id, UserInteractionState interaction) {
        interactions.put(id, interaction);
    }

    public void removeConversation(String id) {
        conversations.remove(id);
    }

    public void removeServiceContext(String id) {
        serviceContexts.remove(id);
    }

    public void removeInteraction(String id) {
        interactions.remove(id);
    }

    public boolean getRequestedToExplain() {
        return requestedToExplain;
    }

    public void setRequestedToExplain(boolean requestedToExplain) {
        this.requestedToExplain = requestedToExplain;
    }

    public void setRecordsUpdated(boolean recordsUpdated) {
        this.recordsUpdated = true;
    }

    public boolean getRecordsUpdated() {
        return recordsUpdated;
    }

    public float getUserDistance() {
        return userDistance;
    }

    public void setUserDistance(float userDistance) {
        this.userDistance = userDistance;
    }

    @Override
    public String toString() {
        return "InteractionState [conversations=" + conversations + ", serviceContexts=" + serviceContexts
                + ", interactions=" + interactions + "]";
    }

}
