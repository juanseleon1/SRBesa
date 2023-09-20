package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public interface SRServiceConfiguration {
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest);

    public DataBESA convertRobotDataToDataBESA(RobotData data);

    public RobotData translateOtherActionsToRobotData(ServiceDataRequest dataRequest);
    
    public DataBESA translateOtherActionsToDataBesa(RobotData data);

    public RobotData convertCancelActionToRobotData(ServiceDataRequest dataRequest);
    
   public RobotData translateOtherCancelActionsToRobotData(ServiceDataRequest dataRequest);

}
