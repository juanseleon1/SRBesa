package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;

public class MotivationAgentConfiguration {

    private RobotResources robotResources;
    private RobotEmotionalConfig robotEmotionalConfig;
    private LatentGoalStructure goalStructure;  
    private AutonomyManager autonomyManager;
    private double threshold;
    private String semanticDictPath;
    private String characterDescPath;
    private RobotEmotionalStrategy robotEmotionalStrategy;
    public RobotResources getResources() {
        return robotResources;
    }

    public RobotEmotionalConfig getEmotionalConfig() {
        return robotEmotionalConfig;
    }

    public LatentGoalStructure getGoalStructure() {
        return goalStructure;
    }

    public AutonomyManager getAutonomyManager() {
        return autonomyManager;
    }

    public double getThreshold() {
        return threshold;
    }

    public String getSemanticDictPath() {
        return semanticDictPath;
    }

    public String getCharacterDescPath() {
        return characterDescPath;
    }

    public RobotEmotionalStrategy getRobotEmotionalStrategy() {
        return robotEmotionalStrategy;
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

    public void setGoalStructure(LatentGoalStructure goalStructure) {
        this.goalStructure = goalStructure;
    }

    public void setAutonomyManager(AutonomyManager autonomyManager) {
        this.autonomyManager = autonomyManager;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public void setSemanticDictPath(String semanticDictPath) {
        this.semanticDictPath = semanticDictPath;
    }

    public void setCharacterDescPath(String characterDescPath) {
        this.characterDescPath = characterDescPath;
    }

    public void setRobotEmotionalStrategy(RobotEmotionalStrategy robotEmotionalStrategy) {
        this.robotEmotionalStrategy = robotEmotionalStrategy;
    }

}
