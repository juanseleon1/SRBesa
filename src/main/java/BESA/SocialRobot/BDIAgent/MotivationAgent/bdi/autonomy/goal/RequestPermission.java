package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal;

import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal.task.AskForPermission;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;

public class RequestPermission extends SRGoal {

    public static RequestPermission buildGoal() {
        AskForPermission permission = new AskForPermission();

        Plan rolePlan = new Plan();

        rolePlan.addTask(permission);

        RationalRole role = new RationalRole(RequestPermission.class.getName(), rolePlan);
        RequestPermission b = new RequestPermission(MotivationAgent.getPlanID(), role,
                RequestPermission.class.getName(), GoalBDITypes.REQUIREMENT);
        return b;
    }

    public RequestPermission(long id, RationalRole role, String description, GoalBDITypes type) {
        super(id, role, description, type, 0);
    }

    @Override
    public double detectGoal(Believes arg0) throws KernellAgentEventExceptionBESA {
        return 100;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent srBeliefs = (BeliefAgent) state.getBelieves();
        return srBeliefs.getInteractionState().getNumberOfPermissionsPending() * 100;
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
        return srBeliefs.getInteractionState().getNumberOfPermissionsPending() == 0;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public double calculateCriticality() {
        return 0;
    }

}
