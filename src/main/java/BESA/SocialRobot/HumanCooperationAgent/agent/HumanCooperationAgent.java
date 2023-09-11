package BESA.SocialRobot.HumanCooperationAgent.agent;



import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventGuard;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.SRSupportAgent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class HumanCooperationAgent extends SRSupportAgent {
public static String interactionEventGuard = "InteractionEventGuard";
    public HumanCooperationAgent(String alias) throws KernelAgentExceptionBESA {
        super(alias, new HumanCooperationAgentState(), buildAgentStruct(), 0.96);
        System.out.println("SensorHandlerAgent Iniciado");
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
            struct.addBehavior("interactionEventGuard");
            struct.bindGuard(interactionEventGuard, InteractionEventGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(HumanCooperationAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription> buildConfiguration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildConfiguration'");
    }
    
}
