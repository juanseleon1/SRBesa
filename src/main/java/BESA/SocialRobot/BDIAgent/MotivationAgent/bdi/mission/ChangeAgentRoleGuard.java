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
        //ReportBESA.debug("ChangingRole" + mission);
        if (data.isDefaultForAgentRole()) {
            bdiState.setCurrentAgentRole(bdiState.getMachineBDIParams().getDefaultAgentRole());
        } else {
            if (mission.hasWeights()) {
                //ReportBESA.debug("ChangingRole has weights");
                bdiState.setCurrentAgentRole(data.getAgentRole());
            }
        }

        if (mission instanceof EmotionalAgentRole) {
            EmotionalAgentRole emotionalAgentRole = (EmotionalAgentRole) mission;
            //ReportBESA.debug("ChangingRole is emotional " + emotionalAgentRole);

            if (data.isDefaultForEmotionalRole()) {
                //ReportBESA.debug("ChangingRole is emotional default");
                beliefAgent.getPsychologicalState().getAgentEmotionalState().resetAgentRole();
            } else if (emotionalAgentRole.isValid()) {
                beliefAgent.getPsychologicalState().getAgentEmotionalState().applyAgentRole(emotionalAgentRole,
                        false);
            }
        }

    }

}
