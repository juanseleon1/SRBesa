package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel;

public class SemanticValue {
    private String name;
    private double value;
    
    public SemanticValue(String name, double value) {
        this.name = name;
        this.value = Utils.checkNegativeOneToOneLimits(value);
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return name + ": " + value;
    }

    public void setValue(double value) {
        this.value = Utils.checkNegativeOneToOneLimits(value);
    }

    public void setName(String name) {
        this.name = name;
    }
}
