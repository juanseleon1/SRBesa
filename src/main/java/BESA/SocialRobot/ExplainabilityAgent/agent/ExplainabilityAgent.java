package BESA.SocialRobot.ExplainabilityAgent.agent;



import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestReasoningGuard;
import BESA.SocialRobot.ExplainabilityAgent.guard.SaveRecordsGuard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class ExplainabilityAgent extends AgentBESA {
public static String name = "ExplainabilityAgent";
public static String saveRecordsGuard = "SaveRecordsGuard";
public static String requestReasoningGuard = "RequestReasoningGuard";

    public ExplainabilityAgent(String alias) throws KernelAgentExceptionBESA {
        super(alias, new ExplainabilityAgentState(), buildAgentStruct(), 0.96);
    }

    @Override
    public void setupAgent() {
        
    }

    @Override
    public void shutdownAgent() {

    }
    
    private static StructBESA buildAgentStruct()
    {
         StructBESA struct=new StructBESA();
        try {
            struct.addBehavior("requestReasoningGuard");
            struct.bindGuard(requestReasoningGuard, RequestReasoningGuard.class);
            struct.addBehavior("saveRecordsGuard");
            struct.bindGuard(saveRecordsGuard, SaveRecordsGuard.class);

        } catch (ExceptionBESA ex) {
            Logger.getLogger(ExplainabilityAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }
    
}
