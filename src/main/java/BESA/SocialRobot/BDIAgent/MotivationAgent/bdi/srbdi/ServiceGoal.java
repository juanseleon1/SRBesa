package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.RationalRole;
import rational.mapping.Believes;

public abstract class ServiceGoal<T extends ServiceContext> extends GoalBDI {
    private double accountability;
    private T userContext;

    public ServiceGoal(long id, RationalRole role, String description, double accountability, T userContext) {
        super(id, role, description, GoalBDITypes.OPORTUNITY);
        this.accountability = accountability;
        this.userContext = userContext;
    }

    public abstract double calculateCriticality(Believes beliefs);

    public double getAccountability() {
        return accountability;
    }

    public void setAccountability(double accountability) {
        this.accountability = accountability;
    }

    public T getUserContext() {
        return userContext;
    }

}
