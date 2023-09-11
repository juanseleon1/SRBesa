package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.ProcessActionGuard;

public class EnrichActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ActionRequestData infoRecibida = (ActionRequestData) event.getData();
        try {
            // TODO: ProcessData and enrich data.
            EventBESA eventBesa = new EventBESA(ProcessActionGuard.class.getName(), infoRecibida);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
