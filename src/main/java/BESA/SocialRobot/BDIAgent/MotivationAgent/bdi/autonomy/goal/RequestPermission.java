package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal;

import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srgoal.SRGoal;
import rational.RationalRole;
import rational.mapping.Believes;

public class RequestPermission extends SRGoal{

    public RequestPermission(long id, RationalRole role, String description, GoalBDITypes type, double accountability) {
        super(id, role, description, type, accountability);
        //TODO Auto-generated constructor stub
    }

    @Override
    public double detectGoal(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detectGoal'");
    }

    @Override
    public double evaluateContribution(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateContribution'");
    }

    @Override
    public double evaluatePlausibility(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluatePlausibility'");
    }

    @Override
    public double evaluateViability(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateViability'");
    }

    @Override
    public boolean goalSucceeded(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goalSucceeded'");
    }

    @Override
    public boolean predictResultUnlegality(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'predictResultUnlegality'");
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
    
}
