package BESA.SocialRobot.ExplainabilityAgent.agent;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.StateBESA;

/**
 *
 * @author juans
 */
public class ExplainabilityAgentState extends StateBESA {
    private List<Record> records;

    public ExplainabilityAgentState() {
        this.records = new ArrayList<>();
    }

    public List<Record> getRecords() {
        return records;
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public void addListOfRecords(List<Record> records) {
        this.records.addAll(records);
    }
}
