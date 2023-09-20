
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import rational.data.InfoData;
import rational.mapping.Believes;


public class PsychologicalState implements Believes {

    private AgentEmotionalState agentEmotionalState;

    public PsychologicalState(String semanticDictPath, String characterDescPath, RobotEmotionalStrategy emotionalStrategy) {
        agentEmotionalState = new AgentEmotionalState(semanticDictPath, characterDescPath, emotionalStrategy);
    }

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

    public AgentEmotionalState getAgentEmotionalState(){
        return agentEmotionalState;
    }
    
}
