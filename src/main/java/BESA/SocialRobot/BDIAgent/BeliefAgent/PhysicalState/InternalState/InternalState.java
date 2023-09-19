
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

    public RobotResources getRobotResources() {
        return robotResources;
    }

    public void setRobotResources(RobotResources robotResources) {
        this.robotResources = robotResources;
    }

    public RobotEmotionalConfig getRobotEmotionalConfig() {
        return robotEmotionalConfig;
    }

    public void setRobotEmotionalConfig(RobotEmotionalConfig robotEmotionalConfig) {
        this.robotEmotionalConfig = robotEmotionalConfig;
    }
    
}