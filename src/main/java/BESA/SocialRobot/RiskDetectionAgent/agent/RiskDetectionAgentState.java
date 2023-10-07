package BESA.SocialRobot.RiskDetectionAgent.agent;

import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.AccidentData;

public abstract class RiskDetectionAgentState extends StateBESA {

    public abstract AccidentData processVideoData(RawVideoData data);

}
