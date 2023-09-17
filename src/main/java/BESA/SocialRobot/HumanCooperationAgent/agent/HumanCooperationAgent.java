package BESA.SocialRobot.HumanCooperationAgent.agent;



import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerData;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerGuard;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionRequestGuard;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.agentUtils.AgentSubscription;
import BESA.SocialRobot.agentUtils.SRSupportAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class HumanCooperationAgent extends SRSupportAgent {
public static String interactionAnswerGuard = "interactionAnswerGuard";
public static String interactionRequestGuard = "interactionRequestGuard";
    public HumanCooperationAgent(String alias) throws KernelAgentExceptionBESA {
        super(alias, new HumanCooperationAgentState(), buildAgentStruct(), 0.96);
    }

    private static StructBESA buildAgentStruct()
    {
         StructBESA struct=new StructBESA();
        try {
            struct.addBehavior("interactionEventGuard");
            struct.bindGuard(interactionAnswerGuard, InteractionAnswerGuard.class);
            struct.bindGuard(interactionRequestGuard, InteractionRequestGuard.class);
        } catch (ExceptionBESA ex) {
            Logger.getLogger(HumanCooperationAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }

    @Override
    public List<AgentSubscription<?,?>> buildConfiguration() {
        AgentSubscription<InteractionAnswerData, InteractionAnswerGuard> messageSubscription = new AgentSubscription<>(ServiceNames.MESSAGE);
        AgentSubscription<InteractionAnswerData, InteractionAnswerGuard> mailSubscription = new AgentSubscription<>(ServiceNames.MAIL);
        AgentSubscription<InteractionAnswerData, InteractionAnswerGuard> tabletEvtSubscription = new AgentSubscription<>(ServiceNames.TABLETEVENT);
        List<AgentSubscription<?, ?>> agSubscriptions = new ArrayList<>();
        agSubscriptions.add(messageSubscription);
        agSubscriptions.add(mailSubscription);
        agSubscriptions.add(tabletEvtSubscription);
        return agSubscriptions;
    }
    
}
