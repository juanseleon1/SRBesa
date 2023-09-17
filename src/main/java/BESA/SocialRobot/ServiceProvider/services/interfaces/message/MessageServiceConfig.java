package BESA.SocialRobot.ServiceProvider.services.interfaces.message;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class MessageServiceConfig implements SRServiceConfiguration{

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertServiceDataToRobotData'");
    }

    @Override
    public DataBESA convertRobotDataToDataBESA(RobotData data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertRobotDataToDataBESA'");
    }

}
