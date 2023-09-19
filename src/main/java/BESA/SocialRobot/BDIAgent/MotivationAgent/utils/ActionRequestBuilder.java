package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import java.util.Map;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;



/**
 *
 * @author juans
 */
public class ActionRequestBuilder {
    private static double actionId = 0;
    public static ActionRequestData buildActionRequest(Map<String, ?> params, String actionName, String taskName){
        double newId = ++actionId;
        ActionRequestData actionRequestData = new ActionRequestData(actionName+newId,params, actionName, taskName);
        return actionRequestData;
    }

        public static ActionRequestData buildActionRequest(String actionName, String taskName){
        double newId = ++actionId;
        ActionRequestData actionRequestData = new ActionRequestData(actionName+newId, null, actionName, taskName);
        return actionRequestData;
    }
}
