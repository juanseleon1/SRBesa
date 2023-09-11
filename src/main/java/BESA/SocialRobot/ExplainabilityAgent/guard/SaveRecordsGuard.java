package BESA.SocialRobot.ExplainabilityAgent.guard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
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
        state.addListOfRecords(infoRecibida.getRecords());
    }

}
