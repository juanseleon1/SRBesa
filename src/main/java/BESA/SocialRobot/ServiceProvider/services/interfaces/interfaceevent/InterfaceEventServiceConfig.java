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
                rd = translateActivateInterfaceAction(dataRequest);
                break;
            case "deactivateInterface":
                rd = translateDeactivateInterfaceAction(dataRequest);
                break;
            case "showVideo":
                rd = translateShowVideoAction(dataRequest);
                break;
            case "quitVideo":
                rd = translateQuitVideoAction(dataRequest);
                break;
            case "pauseVideo":
                rd = translatePauseVideoAction(dataRequest);
                break;
            case "resumeVideo":
                rd = translateResumeVideoAction(dataRequest);
                break;
            case "showImage":
                rd = translateShowImageAction(dataRequest);
                break;
            case "hideImage":
                rd = translateHideImageAction(dataRequest);
                break;
            case "changeInterfaceProperties":
                rd = translateChangeInterfacePropertiesAction(dataRequest);
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
             case "quitVideo":
                db = translateQuitVideoActionResponse(data);
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

    @Override
    public RobotData convertCancelActionToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "activateInterface":
                rd = translateDeactivateInterfaceAction(dataRequest);
                break;
            case "showVideo":
                rd = translateQuitVideoAction(dataRequest);
                break;
            case "showImage":
                rd = translateHideImageAction(dataRequest);
                break;
            default:
                rd = translateOtherCancelActionsToRobotData(dataRequest);
                break;
        }
        return rd;
    }

    protected abstract RobotData translateActivateInterfaceAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateDeactivateInterfaceAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateShowVideoAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translatePauseVideoAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateResumeVideoAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateShowImageAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateHideImageAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateChangeInterfacePropertiesAction(ServiceDataRequest dataRequest);

    protected abstract RobotData translateQuitVideoAction(ServiceDataRequest dataRequest);

    protected abstract DataBESA translateActivateInterfaceResponse(RobotData robotData);

    protected abstract DataBESA translateDeactivateInterfaceResponse(RobotData robotData);

    protected abstract DataBESA translateShowVideoResponse(RobotData robotData);

    protected abstract DataBESA translatePauseVideoResponse(RobotData robotData);

    protected abstract DataBESA translateResumeVideoResponse(RobotData robotData);

    protected abstract DataBESA translateShowImageResponse(RobotData robotData);

    protected abstract DataBESA translateHideImageResponse(RobotData robotData);

    protected abstract DataBESA translateChangeInterfacePropertiesResponse(RobotData robotData);

    protected abstract DataBESA translateQuitVideoActionResponse(RobotData robotData);

    protected abstract DataBESA handleInterfaceEvent(RobotData robotData);


}
