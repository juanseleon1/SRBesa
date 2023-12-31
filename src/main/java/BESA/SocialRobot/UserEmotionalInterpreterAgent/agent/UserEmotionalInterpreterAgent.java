package BESA.SocialRobot.UserEmotionalInterpreterAgent.agent;

import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.CalculateEmotionsGuard;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.SRSupportAgent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class UserEmotionalInterpreterAgent extends SRSupportAgent {
    public static String calculateEmotionsGuard = "CalculateEmotionsGuard";

    public UserEmotionalInterpreterAgent(String alias) throws KernelAgentExceptionBESA {
        super(alias, new UserEmotionalInterpreterState(), buildAgentStruct(), 0.96);
        System.out.println("SensorHandlerAgent Iniciado");
    }

    private static StructBESA buildAgentStruct() {
        StructBESA struct = new StructBESA();
        try {
            struct.addBehavior("CalculateEmotionsGuard");
            struct.bindGuard(calculateEmotionsGuard, CalculateEmotionsGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(UserEmotionalInterpreterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription> buildConfiguration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildConfiguration'");
    }

}
