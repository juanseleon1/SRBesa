package BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class EmotionExtractorServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "getUserEmotions":
                rd = translateGetUserEmotionsAction(dataRequest);
                break;
            default:
                rd = translateOtherActionsToRobotData(dataRequest);
                break;
        }
        return rd;
    }

    @Override
    public DataBESA convertRobotDataToDataBESA(RobotData data) {
        DataBESA db = null;
        String function = data.getFunction();
        switch (function) {
            case "getUserEmotions":
                db = translateGetUserEmotionsResponse(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }


    @Override
    public RobotData convertCancelActionToRobotData(ServiceDataRequest dataRequest) {
        // No expropiable actions
        return null;
    }

    @Override
    public RobotData translateOtherCancelActionsToRobotData(ServiceDataRequest dataRequest) {
        // No expropiable actions
        return null;
    }

    public abstract RobotData translateGetUserEmotionsAction(ServiceDataRequest dataRequest);

    public abstract DataBESA translateGetUserEmotionsResponse(RobotData robotData);

}
