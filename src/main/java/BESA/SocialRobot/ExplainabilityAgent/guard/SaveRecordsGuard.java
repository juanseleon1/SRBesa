package BESA.SocialRobot.ExplainabilityAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;

import java.util.List;

import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class SaveRecordsGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        ExplainabilityAgentState state = (ExplainabilityAgentState) this.getAgent().getState();
        RecordData infoRecibida = (RecordData) ebesa.getData();
        List<EventRecord> records = infoRecibida.getRecords();
        records.forEach(record -> {
            switch (record.getType()) {
                case BELIEFS_AGENT:
                    if (record.getDate().isAfter(state.getLatestInnerStateRecord().getDate())) {
                        state.setLatestInnerStateRecord(record);
                    }
                    break;
                case BELIEFS_USER:
                    if (record.getDate().isAfter(state.getLatestUserStateRecord().getDate())) {
                        state.setLatestUserStateRecord(record);
                    }
                    break;
                case GOALS:
                    if (record.getDate().isAfter(state.getLatestDecisionRecord().getDate())) {
                        state.setLatestDecisionRecord(record);
                    }
                    break;
            }
        });
        state.addListOfRecords(records);
    }

}
