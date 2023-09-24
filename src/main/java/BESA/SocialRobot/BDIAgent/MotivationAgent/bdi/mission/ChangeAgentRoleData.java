package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Kernel.Agent.Event.DataBESA;

public class ChangeAgentRoleData extends DataBESA{
    private AgentRole mission;

    public ChangeAgentRoleData(AgentRole mission) {
        this.mission = mission;
    }

    public AgentRole getAgentRole() {
        return mission;
    }

    public void setAgentRole(AgentRole mission) {
        this.mission = mission;
    }
}
