package BESA.SocialRobot.ExplainabilityAgent.guard;

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
public class RequestReasoningGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        RequestData infoRecibida = (RequestData) ebesa.getData();
        //TODO: save data and process data. Then send to specific agents.
    }

}
