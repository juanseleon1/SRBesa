package BESA.SocialRobot.BDIAgent.explainability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import BESA.BDI.AgentStructuralModel.BDIMachineParams;
import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.guard.RecordData;
import BESA.SocialRobot.ExplainabilityAgent.guard.SaveRecordsGuard;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;
import rational.RationalState;
import rational.explainability.HistoryCollector;
import rational.mapping.Believes;

public class SRHistoryCollector implements HistoryCollector {

    @Override
    public void collectHistoryFromBeliefs(Believes beliefs) {
        BeliefAgent beliefAgent = (BeliefAgent) beliefs;
        List<EventRecord> records = new ArrayList<>();
        List<String> users = beliefAgent.getActiveUsers();
        InteractionState state = beliefAgent.getInteractionState();
        PsychologicalState pState = beliefAgent.getPsychologicalState();
        EventRecord innerRecord = new EventRecord(
                pState.getAgentEmotionalState().getRobotEmotionalState().getEmotions());
        records.add(innerRecord);
        users.forEach(user -> {
            ConversationContext cContext = state.getCurrentConversation(user);
            Map<String, String> queries = cContext.getQueries();
            Map<String, String> subsetQueries = new HashMap<>();
            int i = 0;

            for (Map.Entry<String, String> entry : queries.entrySet()) {
                if (i > 10) {
                    break;
                }
                subsetQueries.put(entry.getKey(), entry.getValue());
            }
            UserInteractionState uState = state.getCurrentInteraction(user);
            EventRecord record = new EventRecord(user, uState.getUserEmotions(),
                    cContext.getConversationRecord().subList(0, 5), subsetQueries);
            records.add(record);
        });
        sendToExplainer(records);

    }

    @Override
    public void collectHistoryFromReasoning(RationalState state) {
        StateBDI stateBDI = (StateBDI) state;
        BDIMachineParams bdiParams = stateBDI.getMachineBDIParams();
        GoalBDI currIntention = bdiParams.getIntention();
        Map<String, Double> currentIntention = new HashMap<>();
        Map<String, Double> otherIntentions = new HashMap<>();
        currentIntention.put("detection", currIntention.getDetectionValue());
        currentIntention.put("contribution", currIntention.getContributionValue());
        currentIntention.put("viability", currIntention.getViabilityValue());
        currentIntention.put("plausibility", currIntention.getPlausibilityLevel());

        List<SortedSet<GoalBDI>> goals = bdiParams.getPyramidGoals().getGeneralHerarchyList();
        for (SortedSet<GoalBDI> setGoal : goals) {
            setGoal.forEach(goal -> {
                otherIntentions.put(goal.getDescription(), goal.getContributionValue());
            });
        }
        EventRecord reasoningRecord = new EventRecord(currIntention.getDescription(), currIntention.getType().name(),
                currentIntention, otherIntentions);
        List<EventRecord> records = new ArrayList<>();
        records.add(reasoningRecord);
        sendToExplainer(records);
    }

    private void sendToExplainer(List<EventRecord> records) {
        try {
            AgHandlerBESA agHandlerBESA;
            RecordData recordData = new RecordData(records);
            EventBESA eventBesa = new EventBESA(SaveRecordsGuard.class.getName(),
                    recordData);
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(ExplainabilityAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
