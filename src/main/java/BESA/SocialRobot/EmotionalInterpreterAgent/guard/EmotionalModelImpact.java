package BESA.SocialRobot.EmotionalInterpreterAgent.guard;

import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import rational.data.InfoData;

public class EmotionalModelImpact extends InfoData{
    private List<EmotionalEvent> emoEv;

    public EmotionalModelImpact(List<EmotionalEvent> emoEv) {
        super("EmotionalModelImpact");
        this.emoEv = emoEv;
    }

    public List<EmotionalEvent> getEmoEv() {
        return emoEv;
    }

    public void setEmoEv(List<EmotionalEvent> emoEv) {
        this.emoEv = emoEv;
    }

  
}
