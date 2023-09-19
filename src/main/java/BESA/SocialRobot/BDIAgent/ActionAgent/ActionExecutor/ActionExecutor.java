package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public abstract class ActionExecutor {
    ActionDescriptor actionDescriptor;
    RobotResources resourceDescriptor;
    RobotEmotionalConfig configDescriptor;
    Map<String, Set<Double>> actionPrimitives;
    Map<String, String> taskActions;

    public ActionExecutor(RobotResources resourceDescriptor, RobotEmotionalConfig configDescriptor) {
        this.resourceDescriptor = resourceDescriptor;
        this.configDescriptor = configDescriptor;
        this.actionPrimitives = new HashMap<>();
        this.taskActions = new HashMap<>();
    }

    public void addPrimitiveToAction(String action, double primitive) {
        actionPrimitives.get(action).add(primitive);
    }

    public void primitiveDoneForAction(String action, Double primitive) {
        actionPrimitives.get(action).remove(primitive);
    }

    public boolean checkActionIsDone(String action) {
        return actionPrimitives.get(action).isEmpty();
    }

    public abstract List<ServiceDataRequest> getActionPrimitives(ActionRequestData data);

    public String getTaskForAction(String action) {
        return taskActions.get(action);
    }

    public void addTaskForAction(String task, String action){
        taskActions.put(action, task);
        if (!actionPrimitives.containsKey(action)) {
            actionPrimitives.put(action, new HashSet<>());
        }
    }

    public boolean isActionPresent(String action){
        return taskActions.containsKey(action);
    }

    public void deleteAction(String action){
        taskActions.remove(action);
        actionPrimitives.remove(action);
    }

}
