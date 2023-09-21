package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import java.util.Map;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.RobotEmotions;

public class Mask {
    Map<RobotEmotions, Float> maskValues;

    public Mask(Map<RobotEmotions, Float> maskValues) {
        this.maskValues = maskValues;
    }

    public Map<RobotEmotions, Float> getMaskValues() {
        return maskValues;
    }

    public void setMaskValues(Map<RobotEmotions, Float> maskValues) {
        this.maskValues = maskValues;
    }

    public float getMaskValue(RobotEmotions emotion) {
        return maskValues.get(emotion);
    }
    
}
