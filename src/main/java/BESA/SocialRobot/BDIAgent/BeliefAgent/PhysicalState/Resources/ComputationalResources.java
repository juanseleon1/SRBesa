
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.Resources;

import rational.data.InfoData;
import rational.mapping.Believes;

public class ComputationalResources implements Believes {

    public ComputationalResources() {
        super();
    }

    @Override
    public boolean update(InfoData si) {

        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }
}