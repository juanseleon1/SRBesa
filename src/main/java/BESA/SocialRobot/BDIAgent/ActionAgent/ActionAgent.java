package BESA.SocialRobot.BDIAgent.ActionAgent;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionExecutor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.ActionModulator;

public class ActionAgent {
    public static String name = "actionAgent";
    private ActionModulator actionModulator;
    private ActionExecutor actionExecutor;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ActionAgent.name = name;
    }

    public ActionModulator getActionModulator() {
        return actionModulator;
    }

    public void setActionModulator(ActionModulator actionModulator) {
        this.actionModulator = actionModulator;
    }

    public ActionExecutor getActionExecutor() {
        return actionExecutor;
    }

    public void setActionExecutor(ActionExecutor actionExecutor) {
        this.actionExecutor = actionExecutor;
    }

}
