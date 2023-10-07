package BESA.SocialRobot.agentUtils;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class AgentSubscription {

    private String serviceAgentId;
    private String dataClassName;
    private String guardClassName;

    public AgentSubscription(ServiceNames agentId, Class<? extends DataBESA> data, Class<? extends GuardBESA> guard ) {
        this.serviceAgentId = agentId.name();
        this.dataClassName = data.getName();
        this.guardClassName = guard.getName();
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

    @Override
    public String toString() {
        return "AgentSubscription{" +
                "serviceAgentId='" + serviceAgentId + '\'' +
                ", dataClassName='" + dataClassName + '\'' +
                ", guardClassName='" + guardClassName + '\'' +
                '}';
    }
}
