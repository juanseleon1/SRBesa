
package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.ProcessRobotEmotionGuard;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterAgent;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterState;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;
import rational.guards.InformationFlowGuard;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;


public class CalculateEmotionsGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        try {
            UserEmotionalInterpreterState state = (UserEmotionalInterpreterState) this.getAgent().getState();
            UserEmotionalData infoRecibida = (UserEmotionalData) ebesa.getData();
            if (!state.isUserModelPresent(infoRecibida.getUserId())) {
                UserEmotionalModel model = state.retrieveEmotionalModel(infoRecibida.getUserId());
                state.addUserModel(infoRecibida.getUserId(), model);
            }
            state.getUserModels().get(infoRecibida.getUserId()).addEmotionBundle(infoRecibida);
            List<UserEmotion> emotions = state.calculateCompositeEmotions(infoRecibida.getUserId());
            UserEmotionalData multimodalData = new UserEmotionalData(infoRecibida.getUserId(),
                    EmotionalDataType.MULTIMODAL,
                    emotions);
            Map<String, Double> emoParams = new ConcurrentHashMap<>();
            emotions.forEach(t -> {
                emoParams.put(t.getName(), t.getIntensity());
            });
            EmotionalData data = new EmotionalData(emoParams);
            data.setOrigin(UserEmotionalInterpreterAgent.name);
            data.setAction("feels");
            EventBESA eventBesa = new EventBESA(ProcessRobotEmotionGuard.class.getName(),
                    data);
            AgHandlerBESA agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(EmotionalInterpreterAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
            eventBesa = new EventBESA(InformationFlowGuard.class.getName(),
                    multimodalData);
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
