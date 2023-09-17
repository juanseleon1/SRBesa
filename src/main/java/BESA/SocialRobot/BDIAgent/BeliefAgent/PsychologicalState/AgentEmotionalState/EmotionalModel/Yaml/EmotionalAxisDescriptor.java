package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml;


import java.util.TreeMap;

public class EmotionalAxisDescriptor {

    public String positiveName;
    public String negativeName;
    public float currentValue;
    public float baseValue;
    public float forgetFactor;
    public TreeMap<String, String> eventInfluences;

    @Override
    public String toString() {
        String str = null;

        str = "\r\n" + positiveName + " - " + negativeName;
        str += "\r\n" + "CV: " + currentValue + " BV: " + baseValue + " FF:" + forgetFactor;
        str += "\r\n" + eventInfluences.toString();
        return str;
    }

    public void validate(String fileName) {
        if (eventInfluences != null) {
            for (String k : eventInfluences.keySet()) {
                SemanticDictionaryDescriptor.validateFloatItem(k, eventInfluences.get(k), fileName);
            }
        }
    }
}
