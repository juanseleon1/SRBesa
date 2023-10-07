package BESA.SocialRobot.RiskDetectionAgent.guard;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.AccidentData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.RiskDetectionAgent.agent.RawVideoData;
import BESA.SocialRobot.RiskDetectionAgent.agent.RiskDetectionAgentState;
import rational.guards.InformationFlowGuard;

public class RiskDetectionGuard extends GuardBESA{

    @Override
    public void funcExecGuard(EventBESA event) {
        RiskDetectionAgentState state = (RiskDetectionAgentState)this.agent.getState();
        RawVideoData data = (RawVideoData)event.getData();
        //FIX: Add habit and anomaly detection
        AccidentData accData = state.processVideoData(data);
        try {
                EventBESA eventBesa = new EventBESA(InformationFlowGuard.class.getName(),
                        accData);
                AgHandlerBESA agHandlerBESA;
                agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
                agHandlerBESA.sendEvent(eventBesa);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }
    }
    
}
