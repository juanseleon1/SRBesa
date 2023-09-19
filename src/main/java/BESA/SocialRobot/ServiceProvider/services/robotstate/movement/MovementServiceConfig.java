package BESA.SocialRobot.ServiceProvider.services.robotstate.movement;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class MovementServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "movementAction":
                rd = translateMovementAction(dataRequest);
                break;
            case "stopMovementAction":
                rd = translateStopMovementAction(dataRequest);
                break;
            case "runAnimationAction":
                rd = translateRunAnimationAction(dataRequest);
                break;
            case "stopAnimationAction":
                rd = translateStopAnimationAction(dataRequest);
                break;
            case "detectWorldModelAction":
                rd = translateDetectWorldModelAction(dataRequest);
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
            case "movementResponse":
                db = translateMovementResponse(data);
                break;
            case "stopMovementResponse":
                db = translateStopMovementResponse(data);
                break;
            case "runAnimationResponse":
                db = translateRunAnimationResponse(data);
                break;
            case "stopAnimationResponse":
                db = translateStopAnimationResponse(data);
                break;
            case "detectWorldModelResponse":
                db = translateDetectWorldModelResponse(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }

    public abstract RobotData translateMovementAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateStopMovementAction(ServiceDataRequest data);

    public abstract RobotData translateRunAnimationAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateStopAnimationAction(ServiceDataRequest data);

    public abstract RobotData translateDetectWorldModelAction(ServiceDataRequest data);

    public abstract DataBESA translateMovementResponse(RobotData robotData);

    public abstract DataBESA translateStopMovementResponse(RobotData robotData);

    public abstract DataBESA translateRunAnimationResponse(RobotData robotData);

    public abstract DataBESA translateStopAnimationResponse(RobotData robotData);

    public abstract DataBESA translateDetectWorldModelResponse(RobotData robotData);

}
