package BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class RawVideoServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "getRawVideo":
                rd = translateGetRawVideoAction(dataRequest);
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
            case "getRawVideo":
                db = translateGetRawVideoResponse(data);
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
    
    public abstract RobotData translateGetRawVideoAction(ServiceDataRequest dataRequest);

    public abstract DataBESA translateGetRawVideoResponse(RobotData robotData);
}
