package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml;


import java.util.TreeMap;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.SemanticDictionary;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.SemanticValue;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality.EmotionElementType;

public class SemanticDictionaryDescriptor {

    public TreeMap<String, String> persons;
    public TreeMap<String, String> events;
    public TreeMap<String, String> objects;

    public void validate(String fileName) {
        if (persons != null) {
            for (String k : persons.keySet()) {
                validateFloatItem(k, persons.get(k), fileName);
            }
        }
        if (events != null) {
            for (String k : events.keySet()) {
                validateFloatItem(k, events.get(k), fileName);
            }
        }
        if (objects != null) {
            for (String k : objects.keySet()) {
                validateFloatItem(k, objects.get(k), fileName);
            }
        }
    }

    protected static void validateFloatItem(String key, String value, String fileName) {
        try {
            Float.parseFloat(value);
        } catch (Exception e) {
            String error = "\r\nError al leer YAML del archivo " + fileName;
            error += "\r\n" + "El atributo '" + key + "' no contiene un valor Float válido.";
            throw new RuntimeException(error);
        }
    }

    public void copyToGlobalSemanticDictionary() {
        SemanticDictionary sd = SemanticDictionary.getInstance();
        if (persons != null) {
            for (String k : persons.keySet()) {
                sd.addSemanticItem(EmotionElementType.Person, new SemanticValue(k, Float.parseFloat(persons.get(k))));
            }
        }
        if (events != null) {
            for (String k : events.keySet()) {
                sd.addSemanticItem(EmotionElementType.Event, new SemanticValue(k, Float.parseFloat(events.get(k))));
            }
        }
        if (objects != null) {
            for (String k : objects.keySet()) {
                sd.addSemanticItem(EmotionElementType.Object, new SemanticValue(k, Float.parseFloat(objects.get(k))));
            }
        }
    }
}
