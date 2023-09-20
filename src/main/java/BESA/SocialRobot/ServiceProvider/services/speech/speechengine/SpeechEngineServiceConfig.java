package BESA.SocialRobot.ServiceProvider.services.speech.speechengine;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class SpeechEngineServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "talk":
                rd = translateTalkAction(dataRequest);
                break;
            case "noTalk":
                rd = translateNoTalkAction(dataRequest);
                break;
            case "talkVolume":
                rd = translateTalkVolumeAction(dataRequest);
                break;
            case "playSound":
                rd = translatePlaySoundAction(dataRequest);
                break;
            case "pauseSound":
                rd = translatePauseSoundAction(dataRequest);
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
            case "talk":
                db = translateTalkResponse(data);
                break;
            case "talkVolume":
                db = translateTalkVolumeResponse(data);
                break;
            case "playSound":
                db = translatePlaySoundResponse(data);
                break;
            case "pauseSound":
                db = translatePauseSoundResponse(data);
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
            case "talk":
                rd = translateNoTalkAction(dataRequest);
                break;
            case "playSound":
                rd = translatePauseSoundAction(dataRequest);
                break;
            default:
                rd = translateOtherCancelActionsToRobotData(dataRequest);
                break;
        }
        return rd;
    }

    public abstract RobotData translateTalkAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateTalkVolumeAction(ServiceDataRequest dataRequest);

    public abstract RobotData translatePlaySoundAction(ServiceDataRequest dataRequest);

    public abstract RobotData translatePauseSoundAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateNoTalkAction(ServiceDataRequest dataRequest);

    public abstract InteractionEventData translateTalkResponse(RobotData robotData);

    public abstract InteractionEventData translateNoTalkResponse(RobotData robotData);

    public abstract DataBESA translateTalkVolumeResponse(RobotData robotData);

    public abstract DataBESA translatePlaySoundResponse(RobotData robotData);

    public abstract DataBESA translatePauseSoundResponse(RobotData robotData);
}
