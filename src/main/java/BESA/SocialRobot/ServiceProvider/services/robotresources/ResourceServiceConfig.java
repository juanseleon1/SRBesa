package BESA.SocialRobot.ServiceProvider.services.robotresources;


import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class ResourceServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "ledsOn":
                rd = translateLedsOnAction(dataRequest);
                break;
            case "ledsOff":
                rd = translateLedsOffAction(dataRequest);
                break;
            case "suspend":
                rd = translateSuspendAction(dataRequest);
                break;
            case "wakeUp":
                rd = translateWakeUpAction(dataRequest);
                break;
            case "ledColor":
                rd = translateLedColorAction(dataRequest);
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
            case "ledsOn":
                db = translateLedsOnActionResponse(data);
                break;
            case "ledsOff":
                db = translateLedsOffActionResponse(data);
                break;
            case "suspend":
                db = translateSuspendActionResponse(data);
                break;
            case "wakeUp":
                db = translateWakeUpActionResponse(data);
                break;
            case "ledColor":
                db = translateLedColorActionResponse(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }

    @Override
    public RobotData convertCancelActionToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
           case "ledsOn":
                rd = translateLedsOffAction(dataRequest);
                break;
            default:
                rd = translateOtherCancelActionsToRobotData(dataRequest);
                break;
        }
        return rd;
    }

    public abstract RobotData translateLedsOnAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateLedsOffAction(ServiceDataRequest data);

    public abstract RobotData translateSuspendAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateWakeUpAction(ServiceDataRequest data);

    public abstract RobotData translateLedColorAction(ServiceDataRequest data);

    public abstract DataBESA translateLedsOnActionResponse(RobotData robotData);

    public abstract DataBESA translateLedsOffActionResponse(RobotData robotData);

    public abstract DataBESA translateSuspendActionResponse(RobotData robotData);

    public abstract DataBESA translateWakeUpActionResponse(RobotData robotData);

    public abstract DataBESA translateLedColorActionResponse(RobotData robotData);

}
