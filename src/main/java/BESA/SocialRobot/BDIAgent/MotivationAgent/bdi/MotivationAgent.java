package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi;

import java.util.List;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.Agent.AgentBDI;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;

public class MotivationAgent extends AgentBDI{
    private static int PLANID = 0;
    public static String aliasRobotAgent = "MotivationAgent";
    public static String aliasEAAgent = "EAAgent";
    public static String aliasSHAAgent = "SHAAgent";
    public static String aliasSPAgent = "SPAgent";
    public static String emf = "ResPwAEntitiesPU";

    public MotivationAgent(int threshold){
        super(aliasRobotAgent, new BeliefAgent(), buildSARGoals(),threshold, new StructBESA());
        setupRationalAgent();
        System.out.println("RobotAgentBDI Iniciado");
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