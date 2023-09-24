package BESA.SocialRobot.BDIAgent.ActionAgent;

import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;


public class ModulatedActionRequestData extends DataBESA {
    private String actionId;
    private String action;
    private String task;
    private List<ServiceDataRequest> serviceDataRequests;

    public ModulatedActionRequestData(String id, String action, String task, List<ServiceDataRequest> serviceDataRequests) {
        this.actionId = id;
        this.action = action;
        this.task = task;
        this.serviceDataRequests = serviceDataRequests;
    }

    public void setActionName(String action) {
        this.action = action;
    }

    public String getActionName() {
        return action;
    }

    public String getId() {
        return actionId;
    }

    public void setId(String actionId) {
        this.actionId = actionId;
    }

    public void setTaskName(String task) {
        this.task = task;
    }

    public String getTaskName() {
        return task;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public List<ServiceDataRequest> getServiceDataRequests() {
        return serviceDataRequests;
    }

    public void setServiceDataRequests(List<ServiceDataRequest> serviceDataRequests) {
        this.serviceDataRequests = serviceDataRequests;
    }

    
}
