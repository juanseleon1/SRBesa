package BESA.SocialRobot.agentUtils;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgent;
import BESA.SocialRobot.InteractiveAgent.guard.HumanInteractionRequestGuard;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import rational.services.ActivateAsynchronousServiceGuard;

public class ServiceUtils {
    private static double requestId = 0;

    public static void requestService(ServiceDataRequest sdr) {
        try {
            EventBESA evt = null;
            AgHandlerBESA agH = null;
            if (sdr.getServiceName().equals(ServiceNames.SPEECHENGINE.name()) && !sdr.isFromInteractionAgent()) {
                agH = AdmBESA.getInstance().getHandlerByAlias(InteractiveAgent.name);
                evt = new EventBESA(HumanInteractionRequestGuard.class.getName(), sdr);
            } else {
                String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(sdr.getServiceName());
                agH = AdmBESA.getInstance().getHandlerByAid(spAgId);
                evt = new EventBESA(ActivateAsynchronousServiceGuard.class.getName(), sdr);
            }
            agH.sendEvent(evt);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(ServiceUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ServiceDataRequest buildServiceDataRequest(ServiceNames serviceName, String function,
            Map<String, ?> params) {
        ServiceDataRequest sdr = new ServiceDataRequest(++requestId, serviceName.name(), function, params);
        return sdr;
    }
}
