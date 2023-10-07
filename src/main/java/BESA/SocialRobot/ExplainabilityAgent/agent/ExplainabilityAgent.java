package BESA.SocialRobot.ExplainabilityAgent.agent;



import BESA.Exception.ExceptionBESA;



import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.ExplainabilityAgent.guard.RequestReasoningGuard;
import BESA.SocialRobot.ExplainabilityAgent.guard.SaveRecordsGuard;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ExplainabilityAgent extends AgentBESA {
public static String name = "ExplainabilityAgent";
public static String saveRecordsGuard = "SaveRecordsGuard";
public static String requestReasoningGuard = "RequestReasoningGuard";

    public ExplainabilityAgent(RecordSaver recordSaver) throws KernelAgentExceptionBESA {
        super(name, new ExplainabilityAgentState(recordSaver), buildAgentStruct(), 0.96);
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
            struct.addBehavior(requestReasoningGuard);
            struct.bindGuard(requestReasoningGuard, RequestReasoningGuard.class);
            struct.addBehavior(saveRecordsGuard);
            struct.bindGuard(saveRecordsGuard, SaveRecordsGuard.class);

        } catch (ExceptionBESA ex) {
            Logger.getLogger(ExplainabilityAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }
    
}
