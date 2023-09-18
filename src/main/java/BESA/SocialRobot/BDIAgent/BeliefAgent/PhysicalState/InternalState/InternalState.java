
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import rational.data.InfoData;
import rational.mapping.Believes;

public class InternalState implements Believes {
    private RobotResources robotResources;
    private RobotEmotionalConfig robotEmotionalConfig;

    public InternalState(RobotResources robotResources, RobotEmotionalConfig robotEmotionalConfig) {
        this.robotResources = robotResources;
        this.robotEmotionalConfig = robotEmotionalConfig;
        robotResources.loadConfig();
        robotEmotionalConfig.loadConfig();
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