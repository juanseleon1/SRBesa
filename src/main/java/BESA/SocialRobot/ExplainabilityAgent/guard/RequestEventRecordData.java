package BESA.SocialRobot.ExplainabilityAgent.guard;

import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;
import rational.data.InfoData;


public class RequestEventRecordData extends InfoData {
    private EventRecord latestInnerStateRecord;
    private EventRecord latestUserStateRecord;
    private EventRecord latestDecisionRecord;
    private boolean isRequest;

    public RequestEventRecordData(EventRecord latestInnerStateRecord, EventRecord latestUserStateRecord, EventRecord latestDecisionRecord) {
        super(null);
        this.latestInnerStateRecord = latestInnerStateRecord;
        this.latestUserStateRecord = latestUserStateRecord;
        this.latestDecisionRecord = latestDecisionRecord;
        this.isRequest = true;
    }

        public RequestEventRecordData() {
        super(null);
        this.isRequest = true;
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

    public boolean isRequest() {
        return isRequest;
    }

    public void setIsRequest(boolean isRequest) {
        this.isRequest = isRequest;
    }
}
