package BESA.SocialRobot.ServiceProvider.agent.guard;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;

//Send by service provider to Agent Executor to sync.
public class RobotReplyData extends DataBESA {

    private RobotData robotData;
    private double primitiveID;
    private String action;

    public RobotReplyData() {
    }

    public RobotReplyData(RobotData robotData, double primitiveID, String action) {
        this.robotData = robotData;
        this.primitiveID = primitiveID;
        this.action = action;
    }

    public RobotData getRobotData() {
        return robotData;
    }

    public double getPrimitiveId() {
        return primitiveID;
    }

    public void setRobotData(RobotData robotData) {
        this.robotData = robotData;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "RobotReplyData [robotData=" + robotData + ", primitiveID=" + primitiveID + ", action=" + action + "]";
    }

    public double getPrimitiveID() {
        return primitiveID;
    }

    public void setPrimitiveID(double primitiveID) {
        this.primitiveID = primitiveID;
    }

}
