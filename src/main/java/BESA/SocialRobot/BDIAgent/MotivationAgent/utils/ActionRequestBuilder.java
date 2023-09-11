package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juans
 */
public class ActionRequestBuilder {
    
    public static ActionRequestData getActionRequestData(ParameterBundle params, String actionName, String taskName){
        ActionRequestData actionRequestData = new ActionRequestData(params, actionName, taskName);
        return actionRequestData;
    }

        public static ActionRequestData getActionRequestData(String actionName, String taskName){
        ActionRequestData actionRequestData = new ActionRequestData(null, actionName, taskName);
        return actionRequestData;
    }
}
