package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.Mission;
import BESA.Kernel.Agent.Event.DataBESA;

public class ChangeMissionData extends DataBESA{
    private Mission mission;

    public ChangeMissionData(Mission mission) {
        this.mission = mission;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
