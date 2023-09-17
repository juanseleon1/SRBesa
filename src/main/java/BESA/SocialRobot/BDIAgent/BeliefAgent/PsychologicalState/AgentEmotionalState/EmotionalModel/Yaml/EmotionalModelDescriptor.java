package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml;


import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class EmotionalModelDescriptor {

    public Set<String> playerNames;
    public TreeMap<String, String> personRelationships;
    public TreeMap<String, String> eventDesirabilities;
    public TreeMap<String, String> objectRelationships;
    public List<EmotionalAxisDescriptor> emotionalAxis;

    @Override
    public String toString() {
        String str = null;

        str = "\r\n" + playerNames.toString();
        str += "\r\n" + personRelationships.toString();
        str += "\r\n" + eventDesirabilities.toString();
        str += "\r\n" + objectRelationships.toString();
        str += "\r\n" + emotionalAxis.toString();
        return str;
    }

    public void validate(String fileName) {
        if (emotionalAxis != null) {
            for (EmotionalAxisDescriptor e : emotionalAxis) {
                e.validate(fileName);
            }
        }
    }
    
}
