package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality.EmotionElementType;

public class SemanticDictionary {

    private static SemanticDictionary instance = null;

    private final Map<String, SemanticValue> objectRelationships;
    private final Map<String, SemanticValue> personRelationships;
    private final Map<String, SemanticValue> eventDesirability;

    private SemanticDictionary() {
        objectRelationships = new ConcurrentHashMap<>();
        personRelationships = new ConcurrentHashMap<>();
        eventDesirability = new ConcurrentHashMap<>();
    }

    public synchronized static SemanticDictionary getInstance() {
        if (instance == null) {
            instance = new SemanticDictionary();
        }
        return instance;
    }

    private Map<String, SemanticValue> getList(EmotionElementType t) {
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

    public void addSemanticItem(EmotionElementType t, SemanticValue s) {
        getList(t).put(s.getName(), s);
    }

    public Collection<SemanticValue> getSemanticItemList(EmotionElementType t) {
        return getList(t).values();
    }

    public Double getSemanticValue(EmotionElementType t, String name) {
        Object o = getList(t).get(name);
        if (o != null) {
            return ((SemanticValue) o).getValue();
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
}