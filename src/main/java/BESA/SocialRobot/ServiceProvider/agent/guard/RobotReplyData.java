package BESA.SocialRobot.ServiceProvider.agent.guard;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;

public class RobotReplyData extends DataBESA{

    private RobotData robotData;
    private int id;
    public RobotData getRobotData() {
        return robotData;
    }

    public int getId() {
        return id;
    }
    
}
