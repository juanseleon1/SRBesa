/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
