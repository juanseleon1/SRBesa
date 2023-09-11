package BESA.SocialRobot.BDIAgent.ActionAgent;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.ParameterBundle;

public class ActionRequestData extends DataBESA{
    private String action;
    private ParameterBundle parameters;

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
    
}
