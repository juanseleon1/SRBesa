package BESA.SocialRobot.BDIAgent.ActionAgent;

import java.util.logging.Level;
import java.util.logging.Logger;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.ProcessActionGuard;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EnrichActionGuard;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;

public class ActionAgent extends AgentBESA {
    public static String name = "ActionAgent";
    public static String processActionGuard = "processActionGuard";
    public static String enrichActionGuard = "enrichActionGuard";

    public ActionAgent(ActionAgentState state)
            throws KernelAgentExceptionBESA {
        super(name, state, buildAgentStruct(), 0.96);
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ActionAgent.name = name;
    }

    @Override
    public void setupAgent() {
    }

    @Override
    public void shutdownAgent() {
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior(processActionGuard);
            struct.bindGuard(processActionGuard, ProcessActionGuard.class);
            struct.addBehavior(enrichActionGuard);
            struct.bindGuard(enrichActionGuard, EnrichActionGuard.class);

        } catch (ExceptionBESA ex) {
            Logger.getLogger(ExplainabilityAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;

    }

}
