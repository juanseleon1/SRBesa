package BESA.SocialRobot.ServiceProvider.adapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;

/**
 *
 * @author juans
 * @param <T>
 */
public abstract class AdapterReceiver<T>{
    
    //TODO: Determine adapter logic. Is receiver the real sender?
    //protected void updateBlvs(SensorData sd) throws ExceptionBESA {
    //    AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(InitRESPwA.aliasSHAAgent);
    //    EventBESA evSP = new EventBESA(CalculateEmotionsGuard.class.getName(),sd);
    //    agH.sendEvent(evSP);
    //}
    
}
