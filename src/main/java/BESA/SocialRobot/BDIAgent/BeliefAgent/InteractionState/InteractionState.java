package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState;

import java.util.HashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import rational.data.InfoData;
import rational.mapping.Believes;

public class InteractionState implements Believes{

    private Map<String, ConversationContext> conversations;
    private Map<String, ServiceContext> serviceContexts;
    private Map<String, UserInteractionState> interactions;

    public InteractionState(){
        conversations = new HashMap<>();
        serviceContexts = new HashMap<>();
        interactions = new HashMap<>();
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

   
    
}
