package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;



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
