package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.guard;

import BESA.Kernel.Agent.Event.DataBESA;

public class RequestUpdateData extends DataBESA{
    private String requestName;

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }
}
