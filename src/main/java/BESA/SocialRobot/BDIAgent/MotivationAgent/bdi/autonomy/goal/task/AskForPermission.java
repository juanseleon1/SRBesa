package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal.task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionRequestData;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;
import rational.mapping.Believes;
import rational.mapping.Task;

public class AskForPermission extends Task {

    @Override
    public void cancelTask(Believes beliefs) {
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        return srBeliefs.getInteractionState().getNumberOfPermissionsPending() == 0;
    }

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        RequestHandler requestHandler = srBeliefs.getInteractionState().getRequestHandler();
        List<Request> requests = requestHandler.getPendingRequests();
        InteractionRequestData data = new InteractionRequestData(requests);

        Map<String, Object> params = new ConcurrentHashMap<>();
        params.put("requests", data.getRequests());
        ServiceDataRequest sData = ServiceUtils.buildServiceDataRequest(ServiceNames.MESSAGE, "sendMessageAction",
                params);
        requestHandler.setRequestsToProcessed(requests);
        ServiceUtils.requestService(sData);
    }

    @Override
    public void interruptTask(Believes beliefs) {
    }

}
