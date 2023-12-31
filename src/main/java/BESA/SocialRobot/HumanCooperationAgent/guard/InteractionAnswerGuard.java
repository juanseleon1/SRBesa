package BESA.SocialRobot.HumanCooperationAgent.guard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.guard.UpdatePermissionRequest;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class InteractionAnswerGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        try {
            EventBESA eventBesa = new EventBESA(UpdatePermissionRequest.class.getName(),
                    ebesa.getData());
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
