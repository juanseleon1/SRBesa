
package BESA.SocialRobot.EmotionalInterpreterAgent.agent;

import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;

/**
 *
 * @author juans
 */
public interface EmotionalInterpreterStrategy {
    
    public List<EmotionalEvent> processEvents(EmotionalData sd);
    
}
