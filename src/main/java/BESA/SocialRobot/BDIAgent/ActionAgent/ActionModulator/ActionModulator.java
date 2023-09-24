package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ModulatedActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.RobotActionProfile;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public class ActionModulator {
    private EmotionalStateData lastEmotionalStateData;
    private EnrichmentStrategy enrichmentStrategy;
    private RobotActionProfile robotActionProfile;

    public ActionModulator(EnrichmentStrategy enrichmentStrategy, RobotActionProfile robotActionProfile) {
        this.enrichmentStrategy = enrichmentStrategy;
        this.robotActionProfile = robotActionProfile;
    }

    public EmotionalStateData getLastEmotionalStateData() {
        return lastEmotionalStateData;
    }

    public void setLastEmotionalStateData(EmotionalStateData lastEmotionalStateData) {
        this.lastEmotionalStateData = lastEmotionalStateData;
    }

    public EnrichmentStrategy getEnrichmentStrategy() {
        return enrichmentStrategy;
    }

    public void setEnrichmentStrategy(EnrichmentStrategy enrichmentStrategy) {
        this.enrichmentStrategy = enrichmentStrategy;
    }

    public ModulatedActionRequestData enrichActionRequestData(ActionRequestData actionRequestData) {
        return enrichmentStrategy.enrichActionRequestData(actionRequestData, robotActionProfile,
                lastEmotionalStateData);
    }

    public RobotActionProfile getRobotActionProfile() {
        return robotActionProfile;
    }

    public void setRobotActionProfile(RobotActionProfile robotActionProfile) {
        this.robotActionProfile = robotActionProfile;
    }

}
