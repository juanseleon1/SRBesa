package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState;

import java.util.HashMap;
import java.util.Map;

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

    public InteractionState() {
        conversations = new HashMap<>();
        serviceContexts = new HashMap<>();
        interactions = new HashMap<>();
        requestHandler = new RequestHandler();
        requestedToExplain = false;
        recordsUpdated = false;

    }

    @Override
    public boolean update(InfoData data) {
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
        } else{
            getCurrentServiceContext().update(data);
        }
        return isUpdated;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
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
        return interactions.get(id);
    }

    public ConversationContext getCurrentConversation(String id) {
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

}
