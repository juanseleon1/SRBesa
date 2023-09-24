package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import java.util.List;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality;

public class EmotionalAgentRole extends AgentRole {
    private List<EmotionalImpact> emotionalImpacts;
    private Personality personality;

    public EmotionalAgentRole(List<EmotionalImpact> emotionalImpacts) {
        this.emotionalImpacts = emotionalImpacts;
    }

    public EmotionalAgentRole(List<EmotionalImpact> emotionalImpacts, Personality personality) {
        this.emotionalImpacts = emotionalImpacts;
        this.personality = personality;
    }

    public List<EmotionalImpact> getEmotionalImpacts() {
        return emotionalImpacts;
    }

    public void setEmotionalImpacts(List<EmotionalImpact> emotionalImpacts) {
        this.emotionalImpacts = emotionalImpacts;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public boolean isValid(){
        return (emotionalImpacts!=null && !emotionalImpacts.isEmpty()) || (personality!=null);
    }
}
