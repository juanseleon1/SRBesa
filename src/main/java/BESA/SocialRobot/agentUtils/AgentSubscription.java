package BESA.SocialRobot.agentUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class AgentSubscription<D extends DataBESA, G extends GuardBESA> {

    private String serviceAgentId;
    private String dataClassName;
    private String guardClassName;

    public AgentSubscription(ServiceNames agentId) {
        this.serviceAgentId = agentId.name();
        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length >= 2) {
                this.dataClassName = typeArguments[0].getClass().getName();
                this.guardClassName = typeArguments[1].getClass().getName();
            }
        }
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
