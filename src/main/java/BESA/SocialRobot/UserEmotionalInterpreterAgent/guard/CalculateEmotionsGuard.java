/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterState;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;
import rational.guards.InformationFlowGuard;

import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class CalculateEmotionsGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        try {
            UserEmotionalInterpreterState state = (UserEmotionalInterpreterState) this.getAgent().getState();
            UserEmotionalData infoRecibida = (UserEmotionalData) ebesa.getData();
            if (!state.isUserModelPresent(infoRecibida.getUserId())) {
                UserEmotionalModel model = state.retrievEmotionalModel(infoRecibida.getUserId());
                state.addUserModel(infoRecibida.getUserId(), model);
            }
            List<UserEmotion> emotions = state.calculateCompositeEmotions(infoRecibida.getUserId());
            UserEmotionalData multimodalData = new UserEmotionalData(infoRecibida.getUserId(),
                    EmotionalDataType.MULTIMODAL,
                    emotions);
            EventBESA eventBesa = new EventBESA(InformationFlowGuard.class.getName(),
                    multimodalData);
            AgHandlerBESA agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
