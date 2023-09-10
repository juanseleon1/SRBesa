/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalModel;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import rational.data.InfoData;
import rational.mapping.Believes;

/**
 *
 * @author mafegarces
 */
public class AgentEmotionalState implements Believes {
    private EmotionalModel emotionalModel;
    //private Map<EmotionPwA, List<Emotion>> emoMap;
    private long tiempoEmocionPredominante;
    private long tiempoAtencion;
    private Long tiempoSinAtencion;
    private long tiempoRelajacion;
    private Long tiempoSinRelajacion;
    private double atencion;
    private double relajacion;


    public AgentEmotionalState() {
        //emoMap = new HashMap<>();
        //for (EmotionPwA epwa : EmotionPwA.values()) {
        //    emoMap.put(epwa, new ArrayList<>());
        //}
    }

    @Override
    public boolean update(InfoData si) {
        System.out.println("BEstadoEmocionalPwA update Received: " + si);
        EmotionalData infoRecibida = (EmotionalData) si;
        if (infoRecibida.getInfo().containsKey("atencion")) {
            atencion = (double) infoRecibida.getInfo().get("atencion");

            if ((double) infoRecibida.getInfo().get("atencion") < 0.5) {
                tiempoSinAtencion = tiempoSinAtencion != null ? tiempoSinAtencion : System.currentTimeMillis();
            } else {
                tiempoSinAtencion = null;
            }
        }
        if (infoRecibida.getInfo().containsKey("relajacion")) {
            relajacion = (double) infoRecibida.getInfo().get("relajacion");
            if ((double) infoRecibida.getInfo().get("relajacion") < 0.5) {
                tiempoSinRelajacion = tiempoSinRelajacion != null ? tiempoSinRelajacion : System.currentTimeMillis();
            } else {
                tiempoSinRelajacion = null;
            }
        }
        if (infoRecibida.getInfo().containsKey("emotions")) {
            //Map<EmotionPwA, Float> emo = (Map<EmotionPwA, Float>) infoRecibida.getInfo().get("emotions");
            //Emotion e;
            //float val;
            //if (emo != null) {
            //    for (EmotionPwA epwa : emo.keySet()) {
            //        val = emo.get(epwa);
            //        e = new Emotion(val);
            //        emoMap.get(epwa).add(e);
            //    }
            //}
        }
        return true;
    }
//    Return if the emotion is pleasant or unpleasant
    //public double getFeedbackEmotion() {
    //    double emotionFeedback = 0.0;
    //    double auxEmotionAverage = 0.0;
    //    for (EmotionPwA entry : emoMap.keySet()) {
//
    //        auxEmotionAverage = getEmotionAverage(emoMap.get(entry));
    //        if (entry.equals(ANGER) || entry.equals(SADNESS)) {
//
    //            auxEmotionAverage *= -1;
    //        }
    //        if (Math.abs(auxEmotionAverage) > Math.abs(emotionFeedback)) {
    //            emotionFeedback = auxEmotionAverage;
    //        }
    //    }
    //    return emotionFeedback;
    //}
//
    //private float getEmotionAverage(List<Emotion> historyEmotionsInActivity) {
    //    float emotionAverage = 0.0f;
//
    //    for (Emotion emotion : historyEmotionsInActivity) {
    //        emotionAverage += emotion.getValence();
    //    }
//
    //    return emotionAverage / historyEmotionsInActivity.size();
    //}
//
    //public double getEmocionPredominante() {
    //    double aux = getFeedbackEmotion();
    //    if (aux > 0 && valencia != 1) {
    //        valencia = 1;
    //        tiempoEmocionPredominante = System.currentTimeMillis();
    //    } else if (aux < 0 && valencia != -1) {
    //        valencia = -1;
    //        tiempoEmocionPredominante = System.currentTimeMillis();
    //    }
    //    return aux;
    //}
//

    public long getTiempoEmocionPredominante() {
        return System.currentTimeMillis() - tiempoEmocionPredominante;
    }

    public void setTiempoEmocionPredominante(long tiempoEmocionPredominante) {
        this.tiempoEmocionPredominante = tiempoEmocionPredominante;
    }

    public long getTiempoAtencion() {
        return System.currentTimeMillis() - tiempoAtencion;
    }

    public void setTiempoAtencion(long tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public long getTiempoRelajacion() {
        return System.currentTimeMillis() - tiempoRelajacion;
    }

    public void setTiempoRelajacion(long tiempoRelajacion) {
        this.tiempoRelajacion = tiempoRelajacion;
    }

    public long getTiempoSinAtencion() {
        if (tiempoSinAtencion == null) {
            return 0;
        }
        return System.currentTimeMillis() - tiempoSinAtencion;
    }

    public void setTiempoSinAtencion(long tiempoSinAtencion) {
        this.tiempoSinAtencion = tiempoSinAtencion;
    }

    public long getTiempoSinRelajacion() {
        if (tiempoSinRelajacion == null) {
            return 0;
        }
        return System.currentTimeMillis() - tiempoSinRelajacion;
    }

    public void setTiempoSinRelajacion(long tiempoSinRelajacion) {
        this.tiempoSinRelajacion = tiempoSinRelajacion;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        super.clone();
        return this;
    }

    public double getAtencion() {
        return atencion;
    }

    public void setAtencion(double atencion) {
        this.atencion = atencion;
    }

    public double getRelajacion() {
        return relajacion;
    }

    public void setRelajacion(double relajacion) {
        this.relajacion = relajacion;
    }

    public EmotionalModel getEmotionalModel() {
        return emotionalModel;
    }

    public void setEmotionalModel(EmotionalModel emotionalModel) {
        this.emotionalModel = emotionalModel;
    }

    public void setTiempoSinAtencion(Long tiempoSinAtencion) {
        this.tiempoSinAtencion = tiempoSinAtencion;
    }

    public void setTiempoSinRelajacion(Long tiempoSinRelajacion) {
        this.tiempoSinRelajacion = tiempoSinRelajacion;
    }

    

}
