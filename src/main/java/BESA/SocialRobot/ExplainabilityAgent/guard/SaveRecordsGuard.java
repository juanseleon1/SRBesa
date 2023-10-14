package BESA.SocialRobot.ExplainabilityAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BESA.BDI.AgentStructuralModel.BDIMachineParams;
import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.GuardBESA;

public class SaveRecordsGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        ExplainabilityAgentState state = (ExplainabilityAgentState) this.getAgent().getState();
        RecordData infoRecibida = (RecordData) ebesa.getData();
        List<EventRecord> records = convertDataIntoRecords(infoRecibida);

        records.forEach(record -> {
            switch (record.getType()) {
                case BELIEFS_AGENT:
                    EventRecord auxAgent = state.getLatestInnerStateRecord();
                    if (auxAgent == null || record.getDate().isAfter(auxAgent.getDate())) {
                        state.setLatestInnerStateRecord(record);
                    }
                    break;
                case BELIEFS_USER:
                    EventRecord auxUser = state.getLatestUserStateRecord();
                    if (auxUser == null || record.getDate().isAfter(auxUser.getDate())) {
                        state.setLatestUserStateRecord(record);
                    }
                    break;
                case GOALS:
                    EventRecord auxDecision = state.getLatestDecisionRecord();
                    if (auxDecision == null || record.getDate().isAfter(auxDecision.getDate())) {
                        state.setLatestDecisionRecord(record);
                    }
                    break;
            }
        });
        state.addListOfRecords(records);
    }

    private List<EventRecord> convertDataIntoRecords(RecordData infoRecibida) {
        List<EventRecord> records = new ArrayList<>();
        if (infoRecibida.isParamsRecord()) {
            BDIMachineParams bdiParams = infoRecibida.getParams();
            GoalBDI currIntention = bdiParams.getIntention();
            String pyramidSnapshot = bdiParams.getPotencialGoals().toString();
            String latentGoalDescription = processGoalStructure(bdiParams.getGoalStructure().getLatentGoals());
            String getCurrentRoleName = bdiParams.getCurrentAgentRole().getName();
            EventRecord reasoningRecord = new EventRecord(currIntention.getDescription(),
                    currIntention.getType().name(),
                    pyramidSnapshot, latentGoalDescription, getCurrentRoleName);
            records.add(reasoningRecord);
        } else if (infoRecibida.isBeliefRecord()) {
            BeliefAgent beliefAgent = infoRecibida.getBeliefAgent();
            List<String> users = beliefAgent.getActiveUsers();
            InteractionState state = beliefAgent.getInteractionState();
            PsychologicalState pState = beliefAgent.getPsychologicalState();
            EmotionalStateData rEmoState = pState.getAgentEmotionalState().getRobotEmotionalState();
            if (rEmoState != null) {
                String serviceContext = null;
                if (beliefAgent.getInteractionState().getActiveService() != null) {
                    serviceContext = beliefAgent.getInteractionState().getCurrentServiceContext().captureRecordData();
                }
                EventRecord innerRecord = new EventRecord(
                        rEmoState.getEmotions(), serviceContext);
                records.add(innerRecord);
            }
            users.forEach(user -> {
                ConversationContext cContext = state.getCurrentConversation(user);
                Map<String, String> queries = cContext.getQueries();
                Map<String, String> subsetQueries = new ConcurrentHashMap<>();
                int i = 0;

                for (Map.Entry<String, String> entry : queries.entrySet()) {
                    if (i > 10) {
                        break;
                    }
                    subsetQueries.put(entry.getKey(), entry.getValue());
                }
                UserInteractionState uState = state.getCurrentInteraction(user);
                EventRecord record = new EventRecord(user, uState.getUserEmotions(),
                        cContext.getConversationRecord(), subsetQueries);
                records.add(record);
            });
        }
        return records;
    }

    private String processGoalStructure(Set<LatentGoal> latentGoals) {
        StringBuilder sb = new StringBuilder();
        latentGoals.forEach(t -> {
            sb.append(t.toString());
            sb.append("\n");
        });
        return sb.toString();
    }

}
