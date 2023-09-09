package BESA.SocialRobot.ServiceProvider.utils;

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
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.Kernel.System.SystemExceptionBESA;
import java.util.logging.Level;
import java.util.logging.Logger;
import rational.services.ActivateAsynchronousServiceGuard;

/**
 *
 * @author juans
 */
public class ResPwaUtils {

    protected boolean expropiated = false;

    public ResPwaUtils() {
        expropiated = false;
    }

    public static void requestService(ServiceProviderDataRequest sdr, BeliefAgent blvs) {
        try {
            blvs.getbEstadoRobot().updateEmotionalVariables();
            String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(sdr.getServiceName());
            // TODO: Como hacer con varios SPs.
            // String SHID =
            // AdmBESA.getInstance().searchAidByAlias(InitRESPwA.aliasSPAgent);
            AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAid(spAgId);
            EventBESA evt = new EventBESA(ActivateAsynchronousServiceGuard.class.getName(), sdr);
            // evt.setSenderAgId(SHID);
            agH.sendEvent(evt);
        } catch (SystemExceptionBESA ex) {
            Logger.getLogger(ResPwaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionBESA e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // TODO: Move this to PwAAgent
    // public static void activateTopic(PepperTopicsNames topic, Believes
    // parameters) {
    //
    // HashMap<String, Object> infoServicio = new HashMap<>();
    // RobotAgentBelieves blvs = (RobotAgentBelieves) parameters;
    // infoServicio.put("TOPICNAME", topic.getTopic());
    // ServiceDataRequest srb =
    // ServiceRequestBuilder.buildRequest(VoiceServiceRequestType.ACTIVATECONVTOPIC,
    // infoServicio);
    // requestService(srb, blvs);
    //
    // }
    //
    // public static void deactivateTopic(PepperTopicsNames topic, Believes
    // parameters) {
    // HashMap<String, Object> infoServicio = new HashMap<>();
    // RobotAgentBelieves blvs = (RobotAgentBelieves) parameters;
    // infoServicio.put("TOPICNAME", topic.getTopic());
    // ServiceDataRequest srb =
    // ServiceRequestBuilder.buildRequest(VoiceServiceRequestType.DEACTCONVTOPIC,
    // infoServicio);
    // requestService(srb, blvs);
    // }
    //
    // public static void updateEmo(Believes believes) {
    // RobotAgentBelieves blvs = (RobotAgentBelieves) believes;
    // blvs.getbEstadoRobot().updateEmotionalVariables();
    // }

    public static void requestService(ServiceProviderDataRequest sdr) {

        try {
            // TODO: Como hacer con varios SPs.
            String spAgId = AdmBESA.getInstance().lookupSPServiceInDirectory(sdr.getServiceName());
            // String SHID =
            // AdmBESA.getInstance().searchAidByAlias(InitRESPwA.aliasSPAgent);
            AgHandlerBESA agH;
            agH = AdmBESA.getInstance().getHandlerByAid(spAgId);
            EventBESA evt = new EventBESA(ActivateAsynchronousServiceGuard.class.getName(), sdr);
            // evt.setSenderAgId(SHID);
            agH.sendEvent(evt);
        } catch (ExceptionBESA e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
