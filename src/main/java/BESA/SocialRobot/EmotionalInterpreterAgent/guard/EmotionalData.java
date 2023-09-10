/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.EmotionalInterpreterAgent.guard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestData;
import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class EmotionalData extends InfoData {

    private Map<String, Object> info;
    private List<EmotionalEvent> emoEv;
    public static EmotionalData fromSensorData(RequestData infoRecibida) {
        EmotionalData em = new EmotionalData();
        em.emoEv = null;
        return em;
    }

    public static EmotionalData getPeriodicData() {
        EmotionalData em = new EmotionalData();
        em.info = new HashMap<>();
        return em;

    }

    public EmotionalData() {
        super("emodata");
        info = new HashMap<>();
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public List<EmotionalEvent> getEmoEv() {
        return emoEv;
    }

    public void setEmoEv(List<EmotionalEvent> emoEv) {
        this.emoEv = emoEv;
    }

}
