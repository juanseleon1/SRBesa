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
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.explainability.SRHistoryCollector;

public class MotivationAgent extends AgentBDI {
    private static int PLANID = 0;
    public static String name = "MotivationAgent";

    public MotivationAgent(RobotEmotionalConfig emotionalConfig, RobotResources resources,
            LatentGoalStructure goalStruct, AutonomyManager autonomyManager, int threshold, String semanticDictPath,
            String characterDescPath, RobotEmotionalStrategy robotEmotionalConfig)
            throws KernelAgentExceptionBESA, ExceptionBESA {
        super(name, new BeliefAgent(resources, emotionalConfig, semanticDictPath, characterDescPath, robotEmotionalConfig), goalStruct,
                autonomyManager, threshold,
                new StructBESA());
        setupRationalAgent();
    }

    public MotivationAgent(MotivationAgentConfiguration config) throws KernelAgentExceptionBESA, ExceptionBESA {
        super(name,
                new BeliefAgent(config.getResources(), config.getEmotionalConfig(), config.getSemanticDictPath(),
                        config.getCharacterDescPath(), config.getRobotEmotionalStrategy()),
                config.getGoalStructure(),
                config.getAutonomyManager(), config.getThreshold(), new StructBESA());
        config.setup(this);
        setupRationalAgent();
    }

    @Override
    public void setupAgentBDI() {
        StateBDI stateBDI = (StateBDI) this.state;
        stateBDI.setHistoryCollector(new SRHistoryCollector());
    }

    @Override
    public void shutdownAgentBDI() {

    }

    public static int getPlanID() {
        return ++PLANID;
    }
}