package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;

public class MotivationAgentConfiguration {

    public RobotResources getResources() {
        return null;
    }

    public RobotEmotionalConfig getEmotionalConfig() {
        return null;
    }

    public LatentGoalStructure getGoalStructure() {
        return null;
    }

    public AutonomyManager getAutonomyManager() {
        return null;
    }

    public double getThreshold() {
        return 0;
    }

    public void setup(MotivationAgent motivationAgent) {
        //TODO: Setup
        /**
         * 1. Setup support Agents 
         * 2. Setup Service Providers
         * 3. Setup Action Provider
         * 4. Setup Motivation Agent
         */
    }

}
