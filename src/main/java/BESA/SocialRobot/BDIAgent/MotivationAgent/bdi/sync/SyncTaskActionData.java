package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync;

import BESA.Kernel.Agent.Event.DataBESA;

public class SyncTaskActionData extends DataBESA{
    private String taskName;
    private String actionId;

    public SyncTaskActionData(String taskName, String actionId) {
        this.taskName = taskName;
        this.actionId = actionId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getActionId() {
        return actionId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
}
