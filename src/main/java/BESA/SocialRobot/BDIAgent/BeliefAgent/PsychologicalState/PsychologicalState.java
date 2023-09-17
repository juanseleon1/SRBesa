/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import rational.data.InfoData;
import rational.mapping.Believes;


public class PsychologicalState implements Believes {

    private AgentEmotionalState agentEmotionalState = new AgentEmotionalState();

    @Override
    public boolean update(InfoData si) {
        if(si instanceof EmotionalModelImpact){
            EmotionalModelImpact emoImpact = (EmotionalModelImpact) si;
                agentEmotionalState.processEmotionalEvents(emoImpact.getEmoEv());
        }
        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        super.clone();
        return this;
    }
    
}
