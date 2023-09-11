package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState;

import java.util.HashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
import rational.data.InfoData;
import rational.mapping.Believes;

public class InteractionState implements Believes{

    private ConversationContext conversation;
    private Map<String, ServiceContext> serviceContexts;
    private Map<String, UserInteractionState> interactions;
    private RequestHandler requestHandler;



    public InteractionState(){
        conversation = new ConversationContext();
        serviceContexts = new HashMap<>();
        interactions = new HashMap<>();
        requestHandler = new RequestHandler();
    }
    @Override
    public boolean update(InfoData data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }
    public ConversationContext getConversations() {
        return conversation;
    }
    public void setConversations(ConversationContext conversation) {
        this.conversation = conversation;
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

}
