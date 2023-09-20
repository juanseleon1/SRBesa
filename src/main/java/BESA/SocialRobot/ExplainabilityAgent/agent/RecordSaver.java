package BESA.SocialRobot.ExplainabilityAgent.agent;

import java.util.List;

import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;

public interface RecordSaver {

    void saveRecords(List<EventRecord> records);

}
