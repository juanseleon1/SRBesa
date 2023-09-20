package BESA.SocialRobot.ExplainabilityAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgent;
import BESA.SocialRobot.InteractiveAgent.guard.HumanInteractionRequestGuard;
import rational.guards.InformationFlowGuard;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;

public class RequestReasoningGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        RequestEventRecordData infoRecibida = (RequestEventRecordData) ebesa.getData();
        ExplainabilityAgentState state = (ExplainabilityAgentState) this.getAgent().getState();
        try {
            if (infoRecibida.isRequest()) {
                AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(InteractiveAgent.name);
                infoRecibida.setLatestDecisionRecord(state.getLatestDecisionRecord());
                infoRecibida.setLatestInnerStateRecord(state.getLatestInnerStateRecord());
                infoRecibida.setLatestUserStateRecord(state.getLatestUserStateRecord());
                EventBESA evt = new EventBESA(HumanInteractionRequestGuard.class.getName(), infoRecibida);
                agH.sendEvent(evt);
            } else {
                AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
                EventBESA sensorEvtA = new EventBESA(InformationFlowGuard.class.getName(), infoRecibida);
                handler.sendEvent(sensorEvtA);
            }
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

    }

}
