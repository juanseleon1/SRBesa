package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;

public class ChangeAgentRoleGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ChangeAgentRoleData data = (ChangeAgentRoleData) event.getData();
        StateBDI bdiState = (StateBDI) this.getAgent().getState();
        BeliefAgent beliefAgent = (BeliefAgent) bdiState.getBelieves();
        AgentRole mission = data.getAgentRole();
        if (mission.hasWeights()) {
            bdiState.setCurrentAgentRole(data.getAgentRole());
        }
        if (mission instanceof EmotionalAgentRole) {
            EmotionalAgentRole emotionalAgentRole = (EmotionalAgentRole) mission;
            if (emotionalAgentRole.isValid()) {
                boolean isDefault = false;
                if (bdiState.getMachineBDIParams().getDefaultAgentRole().equals(emotionalAgentRole)) {
                    isDefault = true;
                }
                beliefAgent.getPsychologicalState().getAgentEmotionalState().applyAgentRole(emotionalAgentRole, isDefault);
            }
        }

    }

}
