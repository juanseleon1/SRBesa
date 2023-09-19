package BESA.SocialRobot.ExplainabilityAgent.guard;

import java.util.List;

import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;
import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class RecordData extends InfoData{
    private List<EventRecord> records;

    public RecordData(List<EventRecord> record) {
        super(null);
        this.records = record;
    }

    public List<EventRecord> getRecords() {
        return records;
    }
    public void setRecords(List<EventRecord> records) {
        this.records = records;
    }
}
