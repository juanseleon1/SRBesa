package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel.Action;

public class RobotActionProfile {

    Map<String, Action> actions;

    public RobotActionProfile() {
        this.actions = new ConcurrentHashMap<>();
    }

    public RobotActionProfile(Map<String, Action> actions) {
        this.actions = actions;
    }

    public Action getAction(String actionName) {
        return actions.get(actionName);
    }

    public Map<String, Action> getActions() {
        return actions;
    }

    public void setActions(Map<String, Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        actions.put(action.getName(), action);
    }
}
