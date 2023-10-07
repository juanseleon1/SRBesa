package BESA.SocialRobot.ExplainabilityAgent.guard;

import BESA.BDI.AgentStructuralModel.BDIMachineParams;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import rational.data.InfoData;


public class RecordData extends InfoData {
    private BeliefAgent beliefAgent;
    private BDIMachineParams params;

    public RecordData(BeliefAgent beliefAgent) {
        super(null);
        this.beliefAgent = beliefAgent;
    }

    public RecordData(BDIMachineParams params) {
        super(null);
        this.params = params;
    }

    public BeliefAgent getBeliefAgent() {
        return beliefAgent;
    }

    public void setBeliefAgent(BeliefAgent beliefAgent) {
        this.beliefAgent = beliefAgent;
    }

    public BDIMachineParams getParams() {
        return params;
    }

    public void setParams(BDIMachineParams params) {
        this.params = params;
    }

    public boolean isBeliefRecord() {
        return beliefAgent != null;
    }

    public boolean isParamsRecord() {
        return params != null;
    }
}
