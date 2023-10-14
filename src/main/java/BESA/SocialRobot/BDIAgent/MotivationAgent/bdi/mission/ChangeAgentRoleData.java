package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Kernel.Agent.Event.DataBESA;

public class ChangeAgentRoleData extends DataBESA {
    private AgentRole agentRole;
    private boolean isDefaultForAgentRole;
    private boolean isDefaultForEmotionalRole;

    public static ChangeAgentRoleData createEmotionalDefaultData() {
        ChangeAgentRoleData data = new ChangeAgentRoleData(new AgentRole("Default"));
        data.setDefaultForEmotionalRole(true);
        return data;
    }

    public static ChangeAgentRoleData createRoleDefaultData() {
        ChangeAgentRoleData data = new ChangeAgentRoleData(new AgentRole("Default"));
        data.setDefaultForAgentRole(true);
        return data;
    }

    public static ChangeAgentRoleData createDefaultData() {
        ChangeAgentRoleData data = new ChangeAgentRoleData(new AgentRole("Default"));
        data.setDefaultForAgentRole(true);
        data.setDefaultForEmotionalRole(true);
        return data;
    }

    public ChangeAgentRoleData(AgentRole agentRole) {
        this.agentRole = agentRole;
        this.isDefaultForAgentRole = false;
        this.isDefaultForEmotionalRole = false;
    }

    public AgentRole getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(AgentRole agentRole) {
        this.agentRole = agentRole;
    }

    public boolean isDefaultForAgentRole() {
        return isDefaultForAgentRole;
    }

    public void setDefaultForAgentRole(boolean isDefaultForAgentRole) {
        this.isDefaultForAgentRole = isDefaultForAgentRole;
    }

    public boolean isDefaultForEmotionalRole() {
        return isDefaultForEmotionalRole;
    }

    public void setDefaultForEmotionalRole(boolean isDefaultForEmotionalRole) {
        this.isDefaultForEmotionalRole = isDefaultForEmotionalRole;
    }

}
