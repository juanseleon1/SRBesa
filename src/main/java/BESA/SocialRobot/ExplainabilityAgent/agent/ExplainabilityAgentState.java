package BESA.SocialRobot.ExplainabilityAgent.agent;

import java.util.ArrayList;
import java.util.List;



import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;

/**
 *
 * @author juans
 */
public class ExplainabilityAgentState extends StateBESA {
    private List<EventRecord> records;

    public ExplainabilityAgentState() {
        this.records = new ArrayList<>();
    }

    public List<EventRecord> getRecords() {
        return records;
    }

    public void addRecord(EventRecord record) {
        this.records.add(record);
    }

    public void addListOfRecords(List<EventRecord> records) {
        this.records.addAll(records);
    }

    public void saveRecords() {
        for (EventRecord record : records) {
            record.save();
        }
    }

}
