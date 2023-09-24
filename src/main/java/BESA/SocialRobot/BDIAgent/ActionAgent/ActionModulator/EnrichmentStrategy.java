package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public interface EnrichmentStrategy {

    ActionRequestData enrichActionRequestData(ActionRequestData actionRequestData,
            EmotionalStateData lastEmotionalStateData);
}
