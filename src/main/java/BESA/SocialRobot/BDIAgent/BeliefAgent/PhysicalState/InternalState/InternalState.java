
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import rational.data.InfoData;
import rational.mapping.Believes;

public class InternalState implements Believes {
    private RobotResources robotResources;

    public InternalState(RobotResources robotResources) {
        this.robotResources = robotResources;
    }

    @Override
    public boolean update(InfoData si) {

        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public RobotResources getRobotResources() {
        return robotResources;
    }

    public void setRobotResources(RobotResources robotResources) {
        this.robotResources = robotResources;
    }

}