package BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class SentimentAnalysisServiceConfig implements SRServiceConfiguration {

    @Override
    public RobotData convertServiceDataToRobotData(ServiceDataRequest dataRequest) {
        RobotData rd = null;
        String function = dataRequest.getFunction();
        switch (function) {
            case "activateSentimentAnalysis":
                rd = translateActivateSentimentAnalysisAction(dataRequest);
                break;
            case "deactivateSentimentAnalysis":
                rd = translateDeactivateSentimentAnalysisAction(dataRequest);
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
            case "activateSentimentAnalysis":
                db = translateActivateSentimentAnalysisResponse(data);
                break;
            case "deactivateSentimentAnalysis":
                db = translateDeactivateSentimentAnalysisResponse(data);
                break;
            default:
                db = translateOtherActionsToDataBesa(data);
                break;
        }
        return db;
    }

    public abstract RobotData translateActivateSentimentAnalysisAction(ServiceDataRequest dataRequest);

    public abstract RobotData translateDeactivateSentimentAnalysisAction(ServiceDataRequest dataRequest);

    public abstract ServiceDataRequest translateActivateSentimentAnalysisResponse(RobotData robotData);

    public abstract ServiceDataRequest translateDeactivateSentimentAnalysisResponse(RobotData robotData);

}
