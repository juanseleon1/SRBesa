package BESA.SocialRobot.HumanCooperationAgent.guard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class InteractionRequestGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        //TODO: send requests to the specific provider.
        // try {
        // EventBESA eventBesa = new EventBESA(ProcessActionGuard.class.getName(),
        // ebesa.getData());
        // AgHandlerBESA agHandlerBESA;
        // agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias();
        // agHandlerBESA.sendEvent(eventBesa);
        // } catch (ExceptionBESA e) {
        // e.printStackTrace();
        // }
    }

}
