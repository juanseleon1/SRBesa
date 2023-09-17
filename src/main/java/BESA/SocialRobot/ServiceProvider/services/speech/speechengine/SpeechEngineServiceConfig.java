package BESA.SocialRobot.ServiceProvider.services.speech.speechengine;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class SpeechEngineServiceConfig implements SRServiceConfiguration{

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;// TODO Auto-generated method stub
        return rd;
    }

    @Override
    public DataBESA convertRobotDataToDataBESA(RobotData data) {
        DataBESA db = null;// TODO Auto-generated method stub
        return db;
    }

}
