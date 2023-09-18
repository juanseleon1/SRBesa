package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi;


import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.Agent.AgentBDI;
import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.explainability.SRHistoryCollector;

public class MotivationAgent extends AgentBDI{
    private static int PLANID = 0;
    public static String name = "MotivationAgent";
    public static String aliasEAAgent = "EAAgent";
    public static String aliasSHAAgent = "SHAAgent";
    public static String aliasSPAgent = "SPAgent";
    public static String emf = "ResPwAEntitiesPU";

    public MotivationAgent(RobotEmotionalConfig emotionalConfig, RobotResources resources,LatentGoalStructure goalStruct, AutonomyManager autonomyManager, int threshold) throws KernelAgentExceptionBESA, ExceptionBESA{
        super(name, new BeliefAgent(resources, emotionalConfig),goalStruct, autonomyManager, threshold, new StructBESA());
        setupRationalAgent();
    }
    
    @Override
    public void setupAgentBDI() {
        StateBDI stateBDI = (StateBDI)this.state;
        stateBDI.setHistoryCollector(new SRHistoryCollector());
        //TODO: add setup for all the related agents.
    }

    @Override
    public void shutdownAgentBDI() {
    
    }

    public static int getPlanID() {
        return ++PLANID;
    }
}