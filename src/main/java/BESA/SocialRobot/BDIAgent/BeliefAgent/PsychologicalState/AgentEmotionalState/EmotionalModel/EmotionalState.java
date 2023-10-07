package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmotionalState {

    private final List<EmotionAxis> emotions;

    public EmotionalState() {
        emotions = new ArrayList<>();
    }

    protected void addEmotionAxis(EmotionAxis ea) {
        EmotionAxis x = getEmotion(ea.getPositiveName(), ea.getNegativeName());
        if (x == null) {
            emotions.add(ea);
        }else{
            x.setCurrentValue(ea.getCurrentValue());
            x.setBaseValue(ea.getBaseValue());
            x.setForgetFactor(ea.getForgetFactor());
            x.setEventInfluences(ea.getEventInfluences());
        }
    }

    protected void updateEmotions(String event, double intensity) {
        for (EmotionAxis e : emotions) {
            e.updateIntensity(event, intensity);
        }
    }

    protected EmotionAxis getEmotion(String positiveName, String negativeName) {
        EmotionAxis ea = null;
        Iterator<EmotionAxis> itr = emotions.iterator();
        if (itr != null) {
            while (itr.hasNext()) {
                EmotionAxis e = (EmotionAxis) itr.next();
                if (e.getPositiveName().toLowerCase().equals(positiveName.toLowerCase())
                        && e.getNegativeName().toLowerCase().equals(negativeName.toLowerCase())) {
                    ea = e;
                    break;
                }
            }
        }
        return ea;
    }

    @Override
    public String toString() {
        return emotions.toString();
    }

    protected EmotionAxis getMostActivatedEmotion() throws CloneNotSupportedException {
        EmotionAxis ea = null;
        Iterator<EmotionAxis> itr = emotions.iterator();
        if (itr != null) {
            while (itr.hasNext()) {
                EmotionAxis e = (EmotionAxis) itr.next();
                if (ea == null || (e.getActivationValue() >= ea.getActivationValue())) {
                    ea = e;
                }
            }
        }
        if (ea != null) {
            return ea.clone();
        } else {
            return null;
        }
    }

    protected List<EmotionAxis> getEmotionsListCopy() throws CloneNotSupportedException {
        List<EmotionAxis> list = new ArrayList<>();
        Iterator<EmotionAxis> itr = emotions.iterator();
        if (itr != null) {
            while (itr.hasNext()) {
                list.add(((EmotionAxis) itr.next()).clone());
            }
        }
        return list;
    }

    public List<EmotionAxis> getEmotions() {
        return emotions;
    }

    @Override
    public EmotionalState clone() {
        try {
            EmotionalState cloned = new EmotionalState();
            for (EmotionAxis axis : emotions) {
                cloned.emotions.add(axis.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
}
