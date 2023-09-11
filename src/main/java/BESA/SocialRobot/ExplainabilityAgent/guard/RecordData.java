package BESA.SocialRobot.ExplainabilityAgent.guard;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
