package BESA.SocialRobot.ExplainabilityAgent.agent;

import java.util.ArrayList;
import java.util.List;



import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;


public class ExplainabilityAgentState extends StateBESA {
    private List<EventRecord> records;
    private RecordSaver recordSaver;

    private EventRecord latestInnerStateRecord;
    private EventRecord latestUserStateRecord;
    private EventRecord latestDecisionRecord;

    public ExplainabilityAgentState(RecordSaver recordSaver) {
        this.records = new ArrayList<>();
        this.recordSaver = recordSaver;
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
        recordSaver.saveRecords(records);
    }

    public EventRecord getLatestInnerStateRecord() {
        return latestInnerStateRecord;
    }

    public void setLatestInnerStateRecord(EventRecord latestInnerStateRecord) {
        this.latestInnerStateRecord = latestInnerStateRecord;
    }

    public EventRecord getLatestUserStateRecord() {
        return latestUserStateRecord;
    }

    public void setLatestUserStateRecord(EventRecord latestUserStateRecord) {
        this.latestUserStateRecord = latestUserStateRecord;
    }

    public EventRecord getLatestDecisionRecord() {
        return latestDecisionRecord;
    }

    public void setLatestDecisionRecord(EventRecord latestDecisionRecord) {
        this.latestDecisionRecord = latestDecisionRecord;
    }

}
