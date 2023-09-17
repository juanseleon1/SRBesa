package BESA.SocialRobot.BDIAgent.ActionAgent;


import BESA.Exception.ExceptionBESA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDataRequest;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Kernel.System.SystemExceptionBESA;
import java.util.logging.Level;
import java.util.logging.Logger;
import rational.services.ActivateAsynchronousServiceGuard;

/**
 *
 * @author juans
 */
public class ServiceUtils {

    public static void requestService(ServiceProviderDataRequest sdr) {
        try {
            String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(sdr.getServiceName());
            AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAid(spAgId);
            EventBESA evt = new EventBESA(ActivateAsynchronousServiceGuard.class.getName(), sdr);
            agH.sendEvent(evt);
        } catch (SystemExceptionBESA ex) {
            Logger.getLogger(ServiceUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
