package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi;

import java.util.HashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;

public class TaskContext {
    private Map<Integer,ActionRequestData> actions;

    public TaskContext() {
        actions = new HashMap<>();
    }

    public boolean isTaskDone() {
        return actions.isEmpty();
    }

    public void addAction(ActionRequestData action) {
        actions.put(action.getId(), action);
    }

}
