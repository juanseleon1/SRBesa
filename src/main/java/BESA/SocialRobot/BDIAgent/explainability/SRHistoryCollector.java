package BESA.SocialRobot.BDIAgent.explainability;

import java.util.ArrayList;
import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RecordData;
import BESA.SocialRobot.ExplainabilityAgent.guard.SaveRecordsGuard;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;
import rational.RationalState;
import rational.explainability.HistoryCollector;
import rational.mapping.Believes;

public class SRHistoryCollector implements HistoryCollector {

    @Override
    public void collectHistoryFromBeliefs(Believes beliefs) {
        // TODO Generate Belief Snapshot
        List<EventRecord> records = new ArrayList<>();
        sendToExplainer(records);

    }

    @Override
    public void collectHistoryFromReasoning(RationalState state) {
        List<EventRecord> records = new ArrayList<>();
        // TODO Generate History from pyramid
        sendToExplainer(records);
    }

    private void sendToExplainer(List<EventRecord> records) {
        try {
            AgHandlerBESA agHandlerBESA;
            RecordData recordData = new RecordData(records);
            EventBESA eventBesa = new EventBESA(SaveRecordsGuard.class.getName(),
                    recordData);
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
