package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import rational.RationalRole;

public abstract class SRGoal extends GoalBDI {
    private double accountability;

    public SRGoal(long id, RationalRole role, String description, GoalBDITypes type, double accountability) {
        super(id, role, description, type);
        this.accountability = accountability;
    }

    public abstract double calculateCriticality();

    public double getAccountability() {
        return accountability;
    }

}
