package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import rational.data.InfoData;
import rational.mapping.Believes;

public class RobotResources implements Believes{

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        super.clone();
        return this;
    }
}
