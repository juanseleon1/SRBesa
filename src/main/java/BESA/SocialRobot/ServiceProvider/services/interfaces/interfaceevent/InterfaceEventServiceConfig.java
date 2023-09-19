package BESA.SocialRobot.ServiceProvider.services.interfaces.interfaceevent;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class InterfaceEventServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "activateInterface":
                rd = translateActivateInterface(dataRequest);
                break;
            case "deactivateInterface":
                rd = translateDeactivateInterface(dataRequest);
                break;
            case "showVideo":
                rd = translateShowVideo(dataRequest);
                break;
            case "pauseVideo":
                rd = translatePauseVideo(dataRequest);
                break;
            case "resumeVideo":
                rd = translateResumeVideo(dataRequest);
                break;
            case "showImage":
                rd = translateShowImage(dataRequest);
                break;
            case "hideImage":
                rd = translateHideImage(dataRequest);
                break;
            case "changeInterfaceProperties":
                rd = translateChangeInterfaceProperties(dataRequest);
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
            case "activateInterface":
                db = translateActivateInterfaceResponse(data);
                break;
            case "deactivateInterface":
                db = translateDeactivateInterfaceResponse(data);
                break;
            case "showVideo":
                db = translateShowVideoResponse(data);
                break;
            case "pauseVideo":
                db = translatePauseVideoResponse(data);
                break;
            case "resumeVideo":
                db = translateResumeVideoResponse(data);
                break;
            case "showImage":
                db = translateShowImageResponse(data);
                break;
            case "hideImage":
                db = translateHideImageResponse(data);
                break;
            case "changeInterfaceProperties":
                db = translateChangeInterfacePropertiesResponse(data);
                break;
            case "interfaceEvent":
                db = handleInterfaceEvent(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }

    public abstract RobotData translateActivateInterface(ServiceDataRequest dataRequest);

    public abstract RobotData translateDeactivateInterface(ServiceDataRequest dataRequest);

    public abstract RobotData translateShowVideo(ServiceDataRequest dataRequest);

    public abstract RobotData translatePauseVideo(ServiceDataRequest dataRequest);

    public abstract RobotData translateResumeVideo(ServiceDataRequest dataRequest);

    public abstract RobotData translateShowImage(ServiceDataRequest dataRequest);

    public abstract RobotData translateHideImage(ServiceDataRequest dataRequest);

    public abstract RobotData translateChangeInterfaceProperties(ServiceDataRequest dataRequest);

    public abstract DataBESA translateActivateInterfaceResponse(RobotData robotData);

    public abstract DataBESA translateDeactivateInterfaceResponse(RobotData robotData);

    public abstract DataBESA translateShowVideoResponse(RobotData robotData);

    public abstract DataBESA translatePauseVideoResponse(RobotData robotData);

    public abstract DataBESA translateResumeVideoResponse(RobotData robotData);

    public abstract DataBESA translateShowImageResponse(RobotData robotData);

    public abstract DataBESA translateHideImageResponse(RobotData robotData);

    public abstract DataBESA translateChangeInterfacePropertiesResponse(RobotData robotData);

    public abstract DataBESA handleInterfaceEvent(RobotData robotData);

}
