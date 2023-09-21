package BESA.SocialRobot.BDIAgent.ActionAgent;

import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionExecutor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.ActionModulator;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public class ActionAgentState extends StateBESA {
    private ActionModulator actionModulator;
    private ActionExecutor actionExecutor;

    public ActionAgentState(ActionModulator actionModulator, ActionExecutor actionExecutor) {
        this.actionModulator = actionModulator;
        this.actionExecutor = actionExecutor;
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

    public void setEmotionalStateData(EmotionalStateData emotionalStateData) {
        actionModulator.setLastEmotionalStateData(emotionalStateData);
    }

}
