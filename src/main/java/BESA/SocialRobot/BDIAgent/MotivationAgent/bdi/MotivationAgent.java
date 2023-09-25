package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.Agent.AgentBDI;
import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.guard.UpdatePermissionRequest;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.ChangeAgentRoleGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.SyncTaskGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.explainability.SRHistoryCollector;
import BESA.SocialRobot.HumanCooperationAgent.guard.SHInteractionAnswerGuard;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterAgent;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.ServiceUtils;
import rational.guards.InformationFlowGuard;

public class MotivationAgent extends AgentBDI {
    private static int PLANID = 0;
    public static String name = "MotivationAgent";

    public MotivationAgent(RobotResources resources,
            LatentGoalStructure goalStruct, AutonomyManager autonomyManager, int threshold, String semanticDictPath,
            String characterDescPath, RobotEmotionalStrategy robotEmotionalConfig, AgentRole defaultAgentRole,
            List<AgentRole> missions)
            throws KernelAgentExceptionBESA, ExceptionBESA {
        super(name,
                new BeliefAgent(resources, semanticDictPath, characterDescPath, robotEmotionalConfig),
                goalStruct,
                autonomyManager, threshold,
                new StructBESA());
        StateBDI stateBDI = (StateBDI) this.state;
        stateBDI.getMachineBDIParams().setDefaultAgentRole(defaultAgentRole);
        stateBDI.getMachineBDIParams().setAgentRoles(missions);
    }

    public MotivationAgent(MotivationAgentConfiguration config) throws KernelAgentExceptionBESA, ExceptionBESA {
        super(name,
                new BeliefAgent(config.getResources(), config.getSemanticDictPath(),
                        config.getCharacterDescPath(), config.getRobotEmotionalStrategy()),
                config.getGoalStructure(),
                config.getAutonomyManager(), config.getThreshold(), buildAgentStruct());
        StateBDI stateBDI = (StateBDI) this.state;
        stateBDI.getMachineBDIParams().setDefaultAgentRole(config.getDefaultAgentRole());
        stateBDI.getMachineBDIParams().setAgentRoles(config.getAgentRoles());
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior("SyncTaskGuard");
            struct.bindGuard("SyncTaskGuard", SyncTaskGuard.class);
            struct.addBehavior("UpdatePermissionRequest");
            struct.bindGuard("UpdatePermissionRequest", UpdatePermissionRequest.class);
            struct.addBehavior("ProcessAgentRoleChange");
            struct.bindGuard("ProcessAgentRoleChange", ChangeAgentRoleGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(UserEmotionalInterpreterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public void setupAgentBDI() {
        StateBDI stateBDI = (StateBDI) this.state;
        stateBDI.setHistoryCollector(new SRHistoryCollector());
        List<AgentSubscription> subs = this.buildConfiguration();
        ServiceUtils.subscribeServices(subs, this.getAid());
    }

    private List<AgentSubscription> buildConfiguration() {
        AgentSubscription resourceSubscription = new AgentSubscription(
                ServiceNames.ROBOT_RESOURCES, RobotData.class, InformationFlowGuard.class);
        AgentSubscription tabletEvtSubscription = new AgentSubscription(
                ServiceNames.INTERFACEEVENT, RobotData.class, SHInteractionAnswerGuard.class);
        List<AgentSubscription> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(resourceSubscription);
        agSubscriptions.add(tabletEvtSubscription);
        return agSubscriptions;
    }

    @Override
    public void shutdownAgentBDI() {

    }

    public static int getPlanID() {
        return ++PLANID;
    }
}