package BESA.SocialRobot.ExplainabilityAgent.guard;

import java.util.List;


import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class RecordData extends InfoData{
    private List<Record> records;

    public RecordData(List<Record> record) {
        super(null);
        this.records = record;
    }

    public List<Record> getRecords() {
        return records;
    }
    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
