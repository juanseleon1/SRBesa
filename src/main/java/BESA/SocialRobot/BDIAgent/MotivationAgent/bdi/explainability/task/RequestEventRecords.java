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
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestEventRecordData;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestReasoningGuard;
import rational.mapping.Believes;

public class RequestEventRecords extends SRTask {

    @Override
    public void cancelTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        srBeliefs.getInteractionState().setRecordsUpdated(false);
        super.cancelTask(beliefs);
    }

    @Override
    public void interruptTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        srBeliefs.getInteractionState().setRecordsUpdated(false);
        super.interruptTask(beliefs);
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
         BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        return srBeliefs.getInteractionState().getRecordsUpdated() && super.checkFinish(beliefs);
    }

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        srBeliefs.getInteractionState().setRecordsUpdated(false);
        RequestHandler requestHandler = srBeliefs.getInteractionState().getRequestHandler();
        List<Request> requests = requestHandler.getPendingRequests();
        RequestEventRecordData data = new RequestEventRecordData();
        try {
            AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
            EventBESA evt = new EventBESA(RequestReasoningGuard.class.getName(), data);
            agH.sendEvent(evt);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
        requestHandler.setRequestsToProcessed(requests);
    }

}
