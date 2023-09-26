
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState;

import java.util.List;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import rational.data.InfoData;
import rational.mapping.Believes;


public class PsychologicalState implements Believes {

    private AgentEmotionalState agentEmotionalState;
    private AgentRole defaultAgentRole;
    private List<AgentRole> roles;

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

    public void setAgentEmotionalState(AgentEmotionalState agentEmotionalState) {
        this.agentEmotionalState = agentEmotionalState;
    }

    public AgentRole getDefaultAgentRole() {
        return defaultAgentRole;
    }

    public void setDefaultAgentRole(AgentRole defaultAgentRole) {
        this.defaultAgentRole = defaultAgentRole;
    }

    public List<AgentRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AgentRole> roles) {
        this.roles = roles;
    }

    
    
}
