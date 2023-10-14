
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState;

import java.util.Map;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalModelImpact;
import rational.data.InfoData;
import rational.mapping.Believes;

public class PsychologicalState implements Believes {

    private AgentEmotionalState agentEmotionalState;
    private AgentRole defaultAgentRole;
    private Map<String, AgentRole> roles;

    public PsychologicalState() {
    }

    public PsychologicalState(String semanticDictPath, String characterDescPath,
            RobotEmotionalStrategy emotionalStrategy) {
        agentEmotionalState = new AgentEmotionalState(semanticDictPath, characterDescPath, emotionalStrategy);
    }

    @Override
    public boolean update(InfoData si) {
        //ReportBESA.debug("PHYSICOLOGICAL STATE" + si.getClass());
        if (si instanceof EmotionalModelImpact) {
            EmotionalModelImpact emoImpact = (EmotionalModelImpact) si;
            agentEmotionalState.processEmotionalEvents(emoImpact.getEmoEv());
        }
        return true;
    }

    @Override
    public PsychologicalState clone() {
        PsychologicalState cloned = new PsychologicalState();
        cloned.agentEmotionalState = agentEmotionalState.clone();
        return cloned;
    }

    public AgentEmotionalState getAgentEmotionalState() {
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

    public Map<String, AgentRole> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, AgentRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PsychologicalState [agentEmotionalState=" + agentEmotionalState + ", defaultAgentRole="
                + defaultAgentRole + ", roles=" + roles + "]";
    }

}
