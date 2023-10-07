package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Personality {

    public enum EmotionElementType {

        Object, Person, Event
    }
    private final Map<String, String> objectRelationships;
    private final Map<String, String> personRelationships;
    private final Map<String, String> eventDesirability;

    public Personality() {
        personRelationships = new ConcurrentHashMap<>();
        objectRelationships = new ConcurrentHashMap<>();
        eventDesirability = new ConcurrentHashMap<>();
    }

    private Map<String, String> getList(EmotionElementType t) {
        switch (t) {
            case Object:
                return this.objectRelationships;
            case Person:
                return this.personRelationships;
            case Event:
                return this.eventDesirability;
            default:
                break;
        }
        return null;
    }

    public void setPersonRelationship(String person, String relationship) {
        personRelationships.put(person, relationship);
    }

    public void setObjectRelationship(String object, String relationship) {
        objectRelationships.put(object, relationship);
    }

    public void setEventDesirability(String event, String desirability) {
        eventDesirability.put(event, desirability);
    }

    public Double getElementSemanticValue(EmotionElementType t, String name) {
        String val = (String)getList(t).get(name);
        if (val != null) {
            return SemanticDictionary.getInstance().getSemanticValue(t, val);
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "Objects" + " -> " + objectRelationships.toString()
                + "\r\nPersons" + " -> " + personRelationships.toString()
                + "\r\nEvents" + " -> " + eventDesirability.toString();
        return str;
    }

    @Override
    public Personality clone() {
        Personality clonedPersonality = new Personality();
        
        // Deep copy the objectRelationships map
        for (Map.Entry<String, String> entry : objectRelationships.entrySet()) {
            clonedPersonality.objectRelationships.put(entry.getKey(), entry.getValue());
        }

        // Deep copy the personRelationships map
        for (Map.Entry<String, String> entry : personRelationships.entrySet()) {
            clonedPersonality.personRelationships.put(entry.getKey(), entry.getValue());
        }

        // Deep copy the eventDesirability map
        for (Map.Entry<String, String> entry : eventDesirability.entrySet()) {
            clonedPersonality.eventDesirability.put(entry.getKey(), entry.getValue());
        }

        return clonedPersonality;
    }

    public Map<String, String> getObjectRelationships() {
        return objectRelationships;
    }

    public Map<String, String> getPersonRelationships() {
        return personRelationships;
    }

    public Map<String, String> getEventDesirability() {
        return eventDesirability;
    }

    

}
