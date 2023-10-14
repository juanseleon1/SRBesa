package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import java.util.List;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality;

public class EmotionalAgentRole extends AgentRole {
    private List<EmotionalImpact> emotionalImpacts;
    private Personality personality;

    public EmotionalAgentRole(String name) {
        super(name);
    }

    public EmotionalAgentRole(List<EmotionalImpact> emotionalImpacts, String name) {
        super(name);
        this.emotionalImpacts = emotionalImpacts;
    }

    public EmotionalAgentRole(List<EmotionalImpact> emotionalImpacts, Personality personality, String name) {
        super(name);
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

    public boolean isValid() {
        return (emotionalImpacts != null && !emotionalImpacts.isEmpty()) || (personality != null);
    }

    public boolean hasPersonality() {
        return personality != null;
    }

    @Override
    public String toString() {
        return "EmotionalAgentRole [emotionalImpacts=" + emotionalImpacts + ", personality=" + personality + "]";
    }

    
}
