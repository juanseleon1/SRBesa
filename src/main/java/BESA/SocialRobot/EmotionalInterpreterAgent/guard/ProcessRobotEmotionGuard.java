/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.EmotionalInterpreterAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import java.util.logging.Level;
import java.util.logging.Logger;
import rational.guards.InformationFlowGuard;

/**
 *
 * @author juans
 */
public class ProcessRobotEmotionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        try {
            EmotionalData infoRecibida = (EmotionalData) ebesa.getData();
            // System.out.println("ProcessEmotionGuard Event Received: "+infoRecibida);
            // EmotionalAnalyzerState eaState =
            // (EmotionalAnalyzerState)this.agent.getState();
            // List<EmotionalEvent> emoList =
            // eaState.getEaStrategy().processEmotion(infoRecibida);
            // infoRecibida.setEmoEv(emoList);
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            EventBESA sensorEvtA = new EventBESA(InformationFlowGuard.class.getName(), infoRecibida);
            handler.sendEvent(sensorEvtA);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(ProcessRobotEmotionGuard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
