package BESA.SocialRobot.ServiceProvider.services.interfaces.message;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class MessageServiceConfig implements SRServiceConfiguration {
    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch(function){
            case "sendMessageAction":
                rd = translateSendMessageAction(dataRequest);
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
        switch(function){
            case "sendMessageResponse":
                db = translateSendMessageResponse(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }
    public abstract RobotData translateSendMessageAction(ServiceDataRequest dataRequest);
    public abstract ServiceDataRequest translateSendMessageResponse(RobotData robotData);


}
