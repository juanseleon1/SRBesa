package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml;


import java.util.List;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionAxis;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalModel;

public class EmotionalModelDescriptors {

    public List<EmotionalModelDescriptor> emotionalModelDescriptors;

    public void validate(String fileName) {
        if (emotionalModelDescriptors != null) {
            for (EmotionalModelDescriptor c : emotionalModelDescriptors) {
                c.validate(fileName);
            }
        }
    }

    public void applyEmotionalModelDescriptor(EmotionalModel p) {
        EmotionalModelDescriptor cd = emotionalModelDescriptors.get(0);

        if (cd.personRelationships != null) {
            for (String k : cd.personRelationships.keySet()) {
                p.setPersonRelationship(k, cd.personRelationships.get(k));
            }
        }
        if (cd.eventDesirabilities != null) {
            for (String k : cd.eventDesirabilities.keySet()) {
                p.setEventDesirability(k, cd.eventDesirabilities.get(k));
            }
        }
        if (cd.objectRelationships != null) {
            for (String k : cd.objectRelationships.keySet()) {
                p.setObjectRelationship(k, cd.objectRelationships.get(k));
            }
        }
        if (cd.emotionalAxis != null) {
            for (EmotionalAxisDescriptor ea : cd.emotionalAxis) {
                EmotionAxis e = new EmotionAxis(ea.positiveName, ea.negativeName, ea.currentValue, ea.baseValue, ea.forgetFactor);
                if (ea.eventInfluences != null) {
                    for (String k : ea.eventInfluences.keySet()) {
                        e.setEventInfluence(k, Float.parseFloat(ea.eventInfluences.get(k)));
                    }
                }
                p.addEmotionAxis(e);
            }
        }
    }
}
