package BESA.SocialRobot.BDIAgent.ActionAgent;

import java.util.Map;

import BESA.Kernel.Agent.Event.DataBESA;


public class ActionRequestData extends DataBESA {
    private String actionId;
    private String action;
    private String task;
    private Map<String, Object> parameters;

    public ActionRequestData(String id, Map<String, Object> parameters, String action, String task) {
        this.actionId = id;
        this.parameters = parameters;
        this.action = action;
        this.task = task;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void setActionName(String action) {
        this.action = action;
    }

    public Map<String, Object> getParameters() {
        return parameters;
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
}
