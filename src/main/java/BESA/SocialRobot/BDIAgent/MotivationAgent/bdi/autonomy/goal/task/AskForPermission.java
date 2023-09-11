package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal.task;

import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
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
        // TODO: Mandar request
    }

    @Override
    public void interruptTask(Believes beliefs) {
    }

}
