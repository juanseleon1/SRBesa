package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi;

import java.util.List;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.Agent.AgentBDI;
import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;

public class MotivationAgent extends AgentBDI{
    private static int PLANID = 0;
    public static String name = "MotivationAgent";
    public static String aliasEAAgent = "EAAgent";
    public static String aliasSHAAgent = "SHAAgent";
    public static String aliasSPAgent = "SPAgent";
    public static String emf = "ResPwAEntitiesPU";

    public MotivationAgent(LatentGoalStructure goalStruct, AutonomyManager autonomyManager, int threshold) throws KernelAgentExceptionBESA, ExceptionBESA{
        super(name, new BeliefAgent(),goalStruct, autonomyManager, threshold, new StructBESA());
        setupRationalAgent();
    }
    
    @Override
    public void setupAgentBDI() {
        //TODO: add all agents setup

    }

    @Override
    public void shutdownAgentBDI() {
    
    }

    protected List<GoalBDI> buildSARGoals(){
        //TODO: add goals
        return null;
    }

    public static int getPlanID() {
        return ++PLANID;
    }
}