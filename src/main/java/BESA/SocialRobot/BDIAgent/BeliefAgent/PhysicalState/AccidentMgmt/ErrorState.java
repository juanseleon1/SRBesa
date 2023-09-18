
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.AccidentMgmt;

import rational.data.InfoData;
import rational.mapping.Believes;

public class ErrorState implements Believes {

    public ErrorState() {
        super();
    }

    @Override
    public boolean update(InfoData si) {

        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        super.clone();
        return this;
    }
}