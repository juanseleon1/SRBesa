package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ModulatedActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.RobotActionProfile;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public interface EnrichmentStrategy {

    ModulatedActionRequestData enrichActionRequestData(ActionRequestData actionRequestData,
            RobotActionProfile robotActionProfile, EmotionalStateData lastEmotionalStateData);
}
