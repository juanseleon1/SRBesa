package BESA.SocialRobot.agentUtils;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;

public class AgentSubscription {

    private String serviceAgentId;
    private String dataClassName;
    private String guardClassName;

    public AgentSubscription(String agentId, DataBESA data, GuardBESA guard){
        this.serviceAgentId= agentId;
        this.dataClassName = data.getClass().getName();
        this.guardClassName = guard.getClass().getName();
    }

    public String getServiceAgentId() {
        return serviceAgentId;
    }
    public void setServiceAgentId(String serviceAgentId) {
        this.serviceAgentId = serviceAgentId;
    }
    public String getDataClassName() {
        return dataClassName;
    }
    public void setDataClassName(String dataClassName) {
        this.dataClassName = dataClassName;
    }
    public String getGuardClassName() {
        return guardClassName;
    }
    public void setGuardClassName(String guardClassName) {
        this.guardClassName = guardClassName;
    }
}
