package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard;

import java.util.Map;

import BESA.Kernel.Agent.Event.DataBESA;

public class EmotionalStateData extends DataBESA{
    Map<RobotEmotions, Double> emotions;

    public EmotionalStateData(Map<RobotEmotions, Double> emotions) {
        this.emotions = emotions;
    }

    public Map<RobotEmotions, Double> getEmotions() {
        return emotions;
    }

    public void setEmotions(Map<RobotEmotions, Double> emotions) {
        this.emotions = emotions;
    }
    public double getEmotion(RobotEmotions emotion){
        return emotions.get(emotion);
    }

    @Override
    public String toString() {
        return "EmotionalStateData [emotions=" + emotions + "]";
    }

}
