package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EnrichActionGuard;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality.EmotionElementType;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class EmotionalModel {

    protected final EmotionalState emotionalState;
    protected final Personality personality;

    public EmotionalModel() {
        this.emotionalState = new EmotionalState();
        this.personality = new Personality();
    }

    public void addEmotionAxis(EmotionAxis ea) {
        try {
            emotionalState.addEmotionAxis(ea.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(EmotionalModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPersonRelationship(String person, String relationship) {
        checkItemInSemanticDictionary(EmotionElementType.Person, relationship);
        personality.setPersonRelationship(person, relationship);
    }

    public void setObjectRelationship(String object, String relationship) {
        checkItemInSemanticDictionary(EmotionElementType.Object, relationship);
        personality.setObjectRelationship(object, relationship);
    }

    public void setEventDesirability(String event, String desirability) {
        checkItemInSemanticDictionary(EmotionElementType.Event, desirability);
        personality.setEventDesirability(event, desirability);
    }

    public void processEmotionalEvent(EmotionalEvent ev) {
        ReportBESA.debug("PROCESSING EMO EVENTS processEmotionalEvent");

        double i = estimateEmotionIntensity(ev);
        if (ev.getPerson() != null) {
            ReportBESA.debug("XEREVENTO: " + ev + " Valencia" + i);
        }
        emotionalState.updateEmotions(ev.getEvent(), i);
        ReportBESA.debug(ev.toString());
        emotionalStateChanged();
    }

    public void processEmotionalEvents(List<EmotionalEvent> evts) {
        ReportBESA.debug("PROCESSING EMO EVENTS processEmotionalEvents");
        evts.forEach((ev) -> {
            double i = estimateEmotionIntensity(ev);
            if (ev.getPerson() != null) {
                ReportBESA.debug("XEREVENTO: " + ev + " Valencia" + i);
            }
            emotionalState.updateEmotions(ev.getEvent(), i);
        });
        emotionalStateChanged();
    }

    private double estimateEmotionIntensity(EmotionalEvent ev) {
        Double person = personality.getElementSemanticValue(EmotionElementType.Person, ev.getPerson());
        Double event = personality.getElementSemanticValue(EmotionElementType.Event, ev.getEvent());
        Double object = personality.getElementSemanticValue(EmotionElementType.Object, ev.getObject());

        person = (person == null) ? 0 : person;
        event = (event == null) ? 0 : event;
        object = (object == null) ? 0 : object;

        double intensity = Utils.Config.PersonWeight * Math.abs(person)
                + Utils.Config.EventWeight * Math.abs(event)
                + Utils.Config.ObjectWeight * Math.abs(object);
        boolean valence = estimateValence(person, event, object);
        intensity = (valence ? 1 : -1) * intensity;
        return intensity;
    }

    private boolean estimateValence(Double person, Double event, Double object) {
        boolean v = false;

        person = (person == null || person == 0) ? 1 : person;
        event = (event == null || event == 0) ? 1 : event;
        object = (object == null || object == 0) ? 1 : object;

        person = person / Math.abs(person);
        event = event / Math.abs(event);
        object = object / Math.abs(object);

        if ((person.equals(event) && event.equals(object))
                || (person.equals(1d) && event.equals(-1d) && object.equals(-1d))) {
            v = true;
        }

        return v;
    }

    public abstract void emotionalStateChanged();

    public EmotionAxis getMostActivatedEmotion() throws CloneNotSupportedException {
        return this.emotionalState.getMostActivatedEmotion();
    }

    public List<EmotionAxis> getEmotionsListCopy() throws CloneNotSupportedException {
        return this.emotionalState.getEmotionsListCopy();
    }

    @Override
    public abstract EmotionalModel clone();
    
    @Override
    public String toString() {
        return personality.toString()
                + "\r\n" + emotionalState.toString();
    }

    private void checkItemInSemanticDictionary(EmotionElementType type, String key) {
        Double v = SemanticDictionary.getInstance().getSemanticValue(type, key);
        if (v == null) {
            String typeName = "Personas";
            if (type == EmotionElementType.Event) {
                typeName = "Eventos";
            } else if (type == EmotionElementType.Object) {
                typeName = "Objetos";
            }
            String msg = "El diccionario semántico de " + typeName + " no contiene un item con el nombre " + key;
            ReportBESA.debug("ERROR: " + msg);
            Logger.getLogger(EmotionalModel.class.getName()).log(Level.WARNING, msg);
        }
    }
    
    protected void sendToActionModulator(EmotionalStateData ed) throws ExceptionBESA {
        ReportBESA.debug("SENDING TO ACTMOD JLEON2");
        AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
        EventBESA sensorEvtA = new EventBESA(EnrichActionGuard.class.getName(), ed);
        handler.sendEvent(sensorEvtA);
    }

    protected void configureEmotionalModel() {
        loadSemanticDictionary();
        loadCharacterDescriptor();
        loadEmotionalAxes();
    }

    protected EmotionAxis getTopEmotionAxis() throws CloneNotSupportedException {
        EmotionAxis maxAx = null;
        double val = Double.NEGATIVE_INFINITY;
        List<EmotionAxis> emoList = emotionalState.getEmotionsListCopy();
        // ReportBESA.debug("Ejes de la lista: " + emoList.size());
        for (EmotionAxis e : emoList) {
            if (e.getCurrentValue() > val) {
                maxAx = e;
                val = e.getCurrentValue();
            }
        }
        return maxAx;
    }

    public abstract void loadSemanticDictionary();

    public abstract void loadCharacterDescriptor();

    public abstract void loadEmotionalAxes();

    public synchronized List<EmotionAxis> getEmotionAxis(){
        return emotionalState.getEmotions();
    }

    public EmotionalState getEmotionalState() {
        return emotionalState;
    }

    public Personality getPersonality() {
        return personality;
    }

}