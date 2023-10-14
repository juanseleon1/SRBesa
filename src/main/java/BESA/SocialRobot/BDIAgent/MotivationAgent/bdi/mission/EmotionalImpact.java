package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import java.util.Map;

public class EmotionalImpact {
    private Map<String, Double> eventInfluences;
    private double forgetFactor;
    private double baseValue;
    private String positiveEmotionName;

    public EmotionalImpact(Map<String, Double> eventInfluences, double forgetFactor, double baseValue) {
        this.eventInfluences = eventInfluences;
        this.forgetFactor = forgetFactor;
        this.baseValue = baseValue;
    }

    public Map<String, Double> getEventInfluences() {
        return eventInfluences;
    }

    public void setEventInfluences(Map<String, Double> eventInfluences) {
        this.eventInfluences = eventInfluences;
    }

    public double getForgetFactor() {
        return forgetFactor;
    }

    public void setForgetFactor(double forgetFactor) {
        this.forgetFactor = forgetFactor;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public String getPositiveEmotionName() {
        return positiveEmotionName;
    }

    public void setPositiveEmotionName(String positiveEmotionName) {
        this.positiveEmotionName = positiveEmotionName;
    }

    @Override
    public String toString() {
        return "EmotionalImpact [eventInfluences=" + eventInfluences + ", forgetFactor=" + forgetFactor + ", baseValue="
                + baseValue + ", positiveEmotionName=" + positiveEmotionName + "]";
    }

    
}
