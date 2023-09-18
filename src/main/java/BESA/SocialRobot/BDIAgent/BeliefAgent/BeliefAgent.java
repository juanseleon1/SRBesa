package BESA.SocialRobot.BDIAgent.BeliefAgent;

import java.util.ArrayList;
import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.PhysicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.UserProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.WorldModel;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import rational.data.InfoData;
import rational.mapping.Believes;

/**
 *
 * @author juans
 */
public class BeliefAgent implements Believes {

    private InteractionState interactionState;
    private PsychologicalState psychologicalState;
    private PhysicalState physicalState;
    private List<UserProfile> userProfiles;
    private WorldModel worldModel;

    public BeliefAgent(RobotResources resources, RobotEmotionalConfig emotionalConfig) {
        interactionState = new InteractionState();
        psychologicalState = new PsychologicalState();
        physicalState = new PhysicalState(resources, emotionalConfig);
        userProfiles = new ArrayList<>();
        worldModel = new WorldModel();
    }

    @Override
    public boolean update(InfoData si) {
        boolean isUpdated = false;
        if (si instanceof EmotionalModelImpact) {
            isUpdated = psychologicalState.update(si);
        }
        return isUpdated;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
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

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public WorldModel getWorldModel() {
        return worldModel;
    }

    public void setWorldModel(WorldModel worldModel) {
        this.worldModel = worldModel;
    }

}
