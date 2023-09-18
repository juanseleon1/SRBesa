
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.Resources;

import rational.data.InfoData;
import rational.mapping.Believes;

public class ExternalResourcesState implements Believes {

    public ExternalResourcesState() {
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