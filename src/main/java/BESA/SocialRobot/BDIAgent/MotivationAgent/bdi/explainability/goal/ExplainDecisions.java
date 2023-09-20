package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.goal;

import java.util.ArrayList;
import java.util.List;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.task.ExplainDecisionMaking;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.task.ExplainInnerState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.task.ExplainUserState;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class ExplainDecisions extends GoalBDI {

    public static ExplainDecisions buildGoal() {
        ExplainDecisionMaking decisions = new ExplainDecisionMaking();
        ExplainUserState userState = new ExplainUserState();
        ExplainInnerState innerState = new ExplainInnerState();

        Plan rolePlan = new Plan();
        List<Task> taskList;
        rolePlan.addTask(decisions);
        taskList = new ArrayList<>();
        taskList.add(decisions);
        rolePlan.addTask(userState, taskList);
        taskList = new ArrayList<>();
        taskList.add(userState);
        rolePlan.addTask(innerState, taskList);

        RationalRole role = new RationalRole(ExplainDecisions.class.getName(), rolePlan);
        ExplainDecisions b = new ExplainDecisions(MotivationAgent.getPlanID(), role,
                ExplainDecisions.class.getName(), GoalBDITypes.REQUIREMENT);
        return b;
    }

    public ExplainDecisions(long id, RationalRole role, String description, GoalBDITypes type) {
        super(id, role, description, type);
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        return srBeliefs.getInteractionState().getRequestedToExplain() ? 100 : 0;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        return 100;
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 100;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 100;
    }

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent srBeliefs = (BeliefAgent) beliefs;
        return !srBeliefs.getInteractionState().getRequestedToExplain();
    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        return true;
    }

}
