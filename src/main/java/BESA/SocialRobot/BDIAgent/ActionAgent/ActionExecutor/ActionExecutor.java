package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor;

import java.util.ArrayList;
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
    Map<String, Set<ServiceDataRequest>> actionPrimitives;
    Map<String, String> taskActions;
    Map<String, List<String>> actionsPerTask;


    public ActionExecutor(RobotResources resourceDescriptor, RobotEmotionalConfig configDescriptor, ActionDescriptor actionDescriptor) {
        this.resourceDescriptor = resourceDescriptor;
        this.configDescriptor = configDescriptor;
        this.actionDescriptor = actionDescriptor;
        this.actionPrimitives = new HashMap<>();
        this.taskActions = new HashMap<>();
        this.actionsPerTask = new HashMap<>();
    }

    public void addPrimitiveToAction(String action, ServiceDataRequest primitive) {
        actionPrimitives.get(action).add(primitive);
    }

    public void primitiveDoneForAction(String action, ServiceDataRequest primitive) {
        actionPrimitives.get(action).remove(primitive);
    }

    public boolean checkActionIsDone(String action) {
        return actionPrimitives.get(action).isEmpty();
    }

    public Set<ServiceDataRequest> getRegisteredPrimitivesPerAction(String action){
        return actionPrimitives.get(action);
    }

    public abstract List<ServiceDataRequest> getActionPrimitives(ActionRequestData data);

    public String getTaskForAction(String action) {
        return taskActions.get(action);
    }

    public void addTaskForAction(String task, String action){
        if(!actionsPerTask.containsKey(task)){
            actionsPerTask.put(task, new ArrayList<>());
        }
        actionsPerTask.get(task).add(action);
        if (!actionPrimitives.containsKey(action)) {
            actionPrimitives.put(action, new HashSet<>());
        }
        taskActions.put(action, task);
    }

    public boolean isActionPresent(String action){
        return taskActions.containsKey(action);
    }

    public void deleteAction(String action){
        String task = taskActions.remove(action);
        actionPrimitives.remove(action);
        actionsPerTask.get(task).remove(action);
    }

    public List<String> getActionsPerTask(String action){
        return actionsPerTask.get(action);
    }

    public void removeTaskData(String taskName) {
        List<String> actions = actionsPerTask.remove(taskName);
        actions.forEach((action) -> {
            taskActions.remove(action);
            actionPrimitives.remove(action);
        });
    }

}
