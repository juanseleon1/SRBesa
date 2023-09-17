package BESA.SocialRobot.ServiceProvider.services.interfaces.tabletevent;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class TabletEventServiceConfig implements SRServiceConfiguration{

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        return rd;
    }

    @Override
    public DataBESA convertRobotDataToDataBESA(RobotData data) {
        DataBESA db = null;
        return db;
    }

}
