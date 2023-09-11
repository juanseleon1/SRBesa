package BESA.SocialRobot.BDIAgent.BeliefAgent;

import java.util.ArrayList;
import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.PhysicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.UserProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.WorldModel;
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

    public BeliefAgent() {
        interactionState = new InteractionState();
        psychologicalState = new PsychologicalState();
        physicalState = new PhysicalState();
        userProfiles = new ArrayList<>();
        worldModel = new WorldModel();
    }

    // AQUI SE MANDA LO DE INFORMATIONFLOW
    // Aqui se accede a BD y se pide info de otros believes.
    @Override
    public boolean update(InfoData si) {
        return true;
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
