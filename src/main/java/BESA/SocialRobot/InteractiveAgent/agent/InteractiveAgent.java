package BESA.SocialRobot.InteractiveAgent.agent;


import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Social.ServiceProvider.agent.GuardServiceProviderSuscribe;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDataSuscribe;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventGuard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class InteractiveAgent extends AgentBESA {
public static String interactionEventGuard = "InteractionEventGuard";
    public InteractiveAgent(String alias) throws KernelAgentExceptionBESA {
        super(alias, new InteractiveAgentState(), buildAgentStruct(), 0.96);
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
            Logger.getLogger(InteractiveAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return struct;
    }
    
 

    public void subscribeServices() throws ExceptionBESA {
        //Todo: Subscribe dynamically
        //String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(ServiceAgentRESPwA.servHumanos);
        //AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAid(spAgId);
        ////Crea el data de suscripcion
        //ServiceProviderDataSuscribe spDataSuscribe = new ServiceProviderDataSuscribe(
        //        CalculateEmotionsGuard.class.getName(),
        //        ServiceProviderBESA.ASYNCHRONIC_SERVICE,
        //        ServiceAgentRESPwA.servHumanos,
        //        SensorData.class.getName());
        ////Crea el evento a enviar
        //EventBESA evSP = new EventBESA(GuardServiceProviderSuscribe.class.getName(), spDataSuscribe);
        //evSP.setSenderAgId(this.getAid());
        ////Env�a el evento
        //agH.sendEvent(evSP);
    }
}
