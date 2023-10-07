package BESA.SocialRobot.BDIAgent.explainability;

import BESA.BDI.AgentStructuralModel.BDIMachineParams;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RecordData;
import BESA.SocialRobot.ExplainabilityAgent.guard.SaveRecordsGuard;
import rational.RationalState;
import rational.explainability.HistoryCollector;
import rational.mapping.Believes;

public class SRHistoryCollector implements HistoryCollector {

    @Override
    public void collectHistoryFromBeliefs(Believes beliefs) {
            BeliefAgent beliefAgent = (BeliefAgent)beliefs;
            try {
                sendToExplainer(beliefAgent.getLocalCopy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void collectHistoryFromReasoning(RationalState state) {
        StateBDI stateBDI = (StateBDI) state;
        BDIMachineParams bdiParams = stateBDI.getMachineBDIParams();
        sendToExplainer(bdiParams);
    }

    private void sendToExplainer( BeliefAgent beliefAgent) {
        try {
            AgHandlerBESA agHandlerBESA;
            RecordData recordData = new RecordData(beliefAgent);
            EventBESA eventBesa = new EventBESA(SaveRecordsGuard.class.getName(),
                    recordData);
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    private void sendToExplainer(BDIMachineParams params) {
        try {
            AgHandlerBESA agHandlerBESA;
            RecordData recordData = new RecordData(params);
            EventBESA eventBesa = new EventBESA(SaveRecordsGuard.class.getName(),
                    recordData);
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
