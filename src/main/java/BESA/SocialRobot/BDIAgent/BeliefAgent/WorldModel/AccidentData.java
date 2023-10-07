package BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel;

import rational.data.InfoData;

public class AccidentData extends InfoData {
    private boolean hasAccident;

    public AccidentData() {
        super(null);
        this.hasAccident = false;
    }

    public boolean isHasAccident() {
        return hasAccident;
    }

    public void setHasAccident(boolean hasAccident) {
        this.hasAccident = hasAccident;
    }

}
