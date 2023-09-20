package BESA.SocialRobot.InteractiveAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestEventRecordData;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestReasoningGuard;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;

public class HumanInteractionRequestGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        if (ebesa.getData() instanceof RequestEventRecordData) {
            try {
                RequestEventRecordData data = (RequestEventRecordData) ebesa.getData();
                InteractiveAgentState state = (InteractiveAgentState) this.getAgent().getState();
                state.setLatestDecisionRecord(data.getLatestDecisionRecord());
                state.setLatestInnerStateRecord(data.getLatestInnerStateRecord());
                state.setLatestUserStateRecord(data.getLatestUserStateRecord());
                RequestEventRecordData reply = new RequestEventRecordData();
                reply.setIsRequest(false);
                AgHandlerBESA agH;
                agH = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
                EventBESA evt = new EventBESA(RequestReasoningGuard.class.getName(), reply);
                agH.sendEvent(evt);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }

        } else {
            InteractiveAgentState state = (InteractiveAgentState) this.getAgent().getState();
            ServiceDataRequest data = (ServiceDataRequest) ebesa.getData();
            data.setFromInteractionAgent(true);
            if (data.getParams().containsKey("origin")) {
                String origin = (String) data.getParams().get("origin");
                if (data.isCancelAction()) {
                    state.requestCompleted(origin);
                } else {
                    state.addRequest(origin);
                }
            }
            ServiceUtils.requestService(data);
        }

    }
}
