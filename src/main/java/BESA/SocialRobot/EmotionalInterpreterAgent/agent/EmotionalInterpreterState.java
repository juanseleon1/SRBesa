/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.EmotionalInterpreterAgent.agent;

import BESA.Kernel.Agent.StateBESA;

/**
 *
 * @author juans
 */
public class EmotionalInterpreterState extends StateBESA{
    private EmotionalInterpreterStrategy eaStrategy;
    
    
    public EmotionalInterpreterState(EmotionalInterpreterStrategy eas){
        eaStrategy=eas;
    }
    public EmotionalInterpreterStrategy getInterpreterStrategy() {
        return eaStrategy;
    }

    public void setInterpreterStrategy(EmotionalInterpreterStrategy eaStrategy) {
        this.eaStrategy = eaStrategy;
    }

}
