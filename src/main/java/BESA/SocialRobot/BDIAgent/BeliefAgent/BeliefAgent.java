package BESA.SocialRobot.BDIAgent.BeliefAgent;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.PhysicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.UserProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.AccidentData;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.WorldModel;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.PingData;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestEventRecordData;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import rational.data.InfoData;
import rational.mapping.Believes;

public class BeliefAgent implements Believes {
    private List<String> activeUsers;
    private InteractionState interactionState;
    private PsychologicalState psychologicalState;
    private PhysicalState physicalState;
    private Map<String, UserProfile> userProfiles;
    private WorldModel worldModel;

    public BeliefAgent() {
    }

    public BeliefAgent(RobotResources resources, String semanticDictPath, String characterDescPath,
            RobotEmotionalStrategy emotionalStrategy) {
        interactionState = new InteractionState();
        psychologicalState = new PsychologicalState(semanticDictPath, characterDescPath, emotionalStrategy);
        physicalState = new PhysicalState(resources);
        userProfiles = new ConcurrentHashMap<>();
        worldModel = new WorldModel();
        activeUsers = new ArrayList<>();
    }

    @Override
    public boolean update(InfoData si) {
        ReportBESA.debug("JLEON12BeliefAgent update Event sent to info: " + si);

        AtomicBoolean isUpdated = new AtomicBoolean(false);
        if (si instanceof PingData) {
            isUpdated.set(true);
        } else if (si instanceof EmotionalModelImpact) {
            ReportBESA.debug("Is impact: " + si);
            isUpdated.set(psychologicalState.update(si));
        } else if (si instanceof UserEmotionalData || si instanceof ConversationEventData
                || si instanceof RequestEventRecordData || si instanceof RobotData) {
            ReportBESA.debug("BeliefAgent update Event sent to interaction state " + si);
            isUpdated.set(interactionState.update(si));
        } else if (si instanceof AccidentData){
            ReportBESA.debug("BeliefAgent update Event sent to world model " + si);
            isUpdated.set(worldModel.update(si));
        }
        activeUsers.forEach((user) -> {
            isUpdated.set(isUpdated.get() || userProfiles.get(user).update(si));
        });

        return isUpdated.get();
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public BeliefAgent getLocalCopy() throws CloneNotSupportedException {
        BeliefAgent clone = new BeliefAgent();
        clone.interactionState = (InteractionState) interactionState.clone();
        clone.psychologicalState = (PsychologicalState) psychologicalState.clone();
        clone.physicalState = (PhysicalState) physicalState.clone();
        clone.activeUsers = new ArrayList<>(activeUsers);
        return clone;
    }

    public InteractionState getInteractionState() {
        return interactionState;
    }

    public void setInteractionState(InteractionState interactionState) {
        this.interactionState = interactionState;
    }

    public PsychologicalState getPsychologicalState() {
        return psychologicalState;
    }

    public void setPsychologicalState(PsychologicalState psychologicalState) {
        this.psychologicalState = psychologicalState;
    }

    public PhysicalState getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(PhysicalState physicalState) {
        this.physicalState = physicalState;
    }

    public Map<String, UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Map<String, UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public WorldModel getWorldModel() {
        return worldModel;
    }

    public void setWorldModel(WorldModel worldModel) {
        this.worldModel = worldModel;
    }

    public UserProfile getUserProfile(String id) {
        return userProfiles.get(id);
    }

    public void addUserProfile(String id, UserProfile userProfile) {
        userProfiles.put(id, userProfile);
    }

    public void registerServiceContext(Class<?> service, ServiceContext context) {

        interactionState.getServiceContexts().put(service.getName(), context);
    }

    public ServiceContext getServiceContext(Class<?> service) {
        return interactionState.getServiceContexts().get(service.getName());
    }

    public List<String> getActiveUsers() {
        return activeUsers;
    }

    @Override
    public String toString() {
        return "BeliefAgent [activeUsers=" + activeUsers + ", interactionState=" + interactionState
                + ", psychologicalState=" + psychologicalState + "]";
    }
}
