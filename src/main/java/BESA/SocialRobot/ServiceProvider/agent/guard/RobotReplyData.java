package BESA.SocialRobot.ServiceProvider.agent.guard;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
//Send by service provider to Agent Executor to sync.
public class RobotReplyData extends DataBESA{

    private RobotData robotData;
    private double primitiveID;
    private String action;

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

    public void setPrimitiveId(double primitiveID) {
        this.primitiveID = primitiveID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
}
