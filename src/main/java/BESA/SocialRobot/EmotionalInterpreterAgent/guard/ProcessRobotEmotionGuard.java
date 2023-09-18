
package BESA.SocialRobot.EmotionalInterpreterAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterState;

import java.util.List;
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
            System.out.println("ProcessEmotionGuard Event Received: "+infoRecibida);
            EmotionalInterpreterState eaState =
            (EmotionalInterpreterState)this.agent.getState();
            List<EmotionalEvent> emoList =
            eaState.getInterpreterStrategy().processEvents(infoRecibida);
            EmotionalModelImpact emoImpact = new EmotionalModelImpact(emoList);
            emoImpact.setEmoEv(emoList);
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            EventBESA sensorEvtA = new EventBESA(InformationFlowGuard.class.getName(), infoRecibida);
            handler.sendEvent(sensorEvtA);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(ProcessRobotEmotionGuard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
