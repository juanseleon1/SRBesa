package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;

public class ProcessActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        //ActionRequestData infoRecibida = (ActionRequestData) event.getData();
        // TODO: Translate action data to a real action. Send real action data requests. Should create and send ServiceDataRequest
        //Should associate task action with service provider action.
        //If expropiation or cancel request is sent, check task action and interrupt related service provider actions. 
    }

}
