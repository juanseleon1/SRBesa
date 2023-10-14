package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ModulatedActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.ProcessActionGuard;

public class EnrichActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        //ReportBESA.debug("EnrichActionGuard");
        ActionAgentState state = (ActionAgentState) this.getAgent().getState();
        DataBESA data = event.getData();
        if (data instanceof EmotionalStateData) {
            EmotionalStateData emotionalStateData = (EmotionalStateData) data;
            state.setEmotionalStateData(emotionalStateData);
        } else {
            try {
                ActionRequestData infoRecibida = (ActionRequestData) event.getData();
                ModulatedActionRequestData enrichedData = state.getActionModulator().enrichActionRequestData(infoRecibida);
                EventBESA eventBesa = new EventBESA(ProcessActionGuard.class.getName(), enrichedData);
                AgHandlerBESA agHandlerBESA;
                agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
                agHandlerBESA.sendEvent(eventBesa);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }
        }

    }

}
