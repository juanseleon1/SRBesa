package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.Mission;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;

public class ChangeMissionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ChangeMissionData data = (ChangeMissionData) event.getData();
        StateBDI bdiState = (StateBDI) this.getAgent().getState();
        BeliefAgent beliefAgent = (BeliefAgent) bdiState.getBelieves();
        Mission mission = data.getMission();
        if (mission.hasWeights()) {
            bdiState.setCurrentMission(data.getMission());
        }
        if (mission instanceof EmotionalMission) {
            EmotionalMission emotionalMission = (EmotionalMission) mission;
            if (emotionalMission.isValid()) {
                beliefAgent.getPsychologicalState().getAgentEmotionalState().applyMission(emotionalMission);
            }
        }

    }

}
