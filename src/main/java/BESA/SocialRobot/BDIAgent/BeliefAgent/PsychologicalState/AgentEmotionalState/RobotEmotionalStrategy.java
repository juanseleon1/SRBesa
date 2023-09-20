package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public interface RobotEmotionalStrategy {

    EmotionalStateData processEmotionsForRobot(AgentEmotionalState agentEmotionalState);

}
