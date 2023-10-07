package BESA.SocialRobot.HumanCooperationAgent.guard;



import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import BESA.Kernel.Agent.GuardBESA;


public class SHInteractionRequestGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        InteractionRequestData ird = (InteractionRequestData) ebesa.getData();
        Map<String, Object> params = new ConcurrentHashMap<>();
        params.put("requests", ird.getRequests());
        ServiceDataRequest data = ServiceUtils.buildServiceDataRequest(ServiceNames.MAIL, "sendMailAction", params);
        ServiceUtils.requestService(data);
    }

}
