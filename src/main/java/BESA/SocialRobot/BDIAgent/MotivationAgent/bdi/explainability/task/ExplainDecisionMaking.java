package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.task;

import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import BESA.SocialRobot.HumanCooperationAgent.agent.HumanCooperationAgent;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionRequestData;
import BESA.SocialRobot.HumanCooperationAgent.guard.SHInteractionRequestGuard;
import rational.mapping.Believes;

public class ExplainDecisionMaking extends SRTask {

    @Override
    public void cancelTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        srBeliefs.getInteractionState().setRequestedToExplain(false);
        super.cancelTask(beliefs);
    }

    @Override
    public void interruptTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        srBeliefs.getInteractionState().setRequestedToExplain(false);
        super.interruptTask(beliefs);
    }

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        RequestHandler requestHandler = srBeliefs.getInteractionState().getRequestHandler();
        List<Request> requests = requestHandler.getPendingRequests();
        InteractionRequestData data = new InteractionRequestData(requests);
        try {
            AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(HumanCooperationAgent.name);
            EventBESA evt = new EventBESA(SHInteractionRequestGuard.class.getName(), data);
            agH.sendEvent(evt);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
        requestHandler.setRequestsToProcessed(requests);
    }

}
