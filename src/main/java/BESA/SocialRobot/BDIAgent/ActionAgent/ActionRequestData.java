package BESA.SocialRobot.BDIAgent.ActionAgent;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.ParameterBundle;

public class ActionRequestData extends DataBESA{
    private int id;
    private String action;
    private String task;


    private ParameterBundle parameters;
    public ActionRequestData(ParameterBundle parameters, String action, String task) {
        this.parameters = parameters;
        this.action = action;
        this.task = task;
    }

    public void setParameters(ParameterBundle parameters) {
        this.parameters = parameters;
    }
    public void setActionName(String action) {
        this.action = action;
    }
    public ParameterBundle getParameters() {
        return parameters;
    }
    public String getActionName() {
        return action;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTaskName(String task) {
        this.task = task;
    }
    public String getTaskName() {
        return task;
    }
}
