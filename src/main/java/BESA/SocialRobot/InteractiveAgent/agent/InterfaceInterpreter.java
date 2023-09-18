package BESA.SocialRobot.InteractiveAgent.agent;

import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;

public interface InterfaceInterpreter {

    EmotionalData processInterfaceInteraction(InteractionEventData data);

}
