package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class ActionExecutor {
    RobotResources resourceDescriptor;
    Map<String, Set<ServiceDataRequest>> actionPrimitives;
    Map<String, Set<Double>> tracker;
    Map<Double, String> primitiveActionRelation;
    Map<String, String> taskActions;
    Map<String, List<String>> actionsPerTask;

    public ActionExecutor(RobotResources resourceDescriptor) {
        this.resourceDescriptor = resourceDescriptor;
        this.actionPrimitives = new ConcurrentHashMap<>();
        tracker = new ConcurrentHashMap<>();
        primitiveActionRelation = new ConcurrentHashMap<>();
        this.taskActions = new ConcurrentHashMap<>();
        this.actionsPerTask = new ConcurrentHashMap<>();
    }

    public void addPrimitiveToAction(String action, ServiceDataRequest primitive) {
        actionPrimitives.get(action).add(primitive);
        tracker.get(action).add(primitive.getId());
        primitiveActionRelation.put(primitive.getId(), action);
    }

    public boolean checkIfActionHasPrimitive(String action, Double primitiveId) {
        return action != null && tracker.containsKey(action) && tracker.get(action).contains(primitiveId);
    }

    public void primitiveDoneForAction(String action, ServiceDataRequest primitive) {
        // ReportBESA.debug("Primitive done for action: " + action + " primitive: " +
        // primitive);
        // ReportBESA.debug("Action primitives: " + actionPrimitives.get(action));
        // ReportBESA.debug("tracker primitives: " + tracker.get(action));
        // ReportBESA.debug("Action primitives should be removed: " +
        // tracker.get(action).contains(primitive.getId()));
        tracker.get(action).remove(primitive.getId());
        primitiveActionRelation.remove(primitive.getId());
    }

    public String getActionPerPrimitiveId(Double primitiveId) {
        return primitiveActionRelation.get(primitiveId);
    }

    public boolean checkActionIsDone(String action) {
        // ReportBESA.debug("Check action is done: " + tracker.get(action));
        // ReportBESA.debug("Check action is done: " + tracker.get(action).isEmpty());
        return tracker.get(action).isEmpty();
    }

    public Set<ServiceDataRequest> getRegisteredPrimitivesPerAction(String action) {
        return actionPrimitives.get(action);
    }

    public String getTaskForAction(String action) {
        return taskActions.get(action);
    }

    public void addTaskForAction(String task, String action) {
        if (!actionsPerTask.containsKey(task)) {
            actionsPerTask.put(task, new ArrayList<>());
        }
        actionsPerTask.get(task).add(action);
        if (!actionPrimitives.containsKey(action)) {
            actionPrimitives.put(action, new HashSet<>());
            tracker.put(action, new HashSet<>());
        }
        taskActions.put(action, task);
    }

    public boolean isActionPresent(String action) {
        return taskActions.containsKey(action);
    }

    public void deleteAction(String action) {
        String task = taskActions.remove(action);
        actionPrimitives.remove(action);
        tracker.remove(action);
        actionsPerTask.get(task).remove(action);
        primitiveActionRelation.forEach((primitive, actionName) -> {
            if (actionName.equals(action)) {
                primitiveActionRelation.remove(primitive);
            }
        });
    }

    public List<String> getActionsPerTask(String action) {
        return actionsPerTask.get(action);
    }

    public void removeTaskData(String taskName) {
        List<String> actions = actionsPerTask.remove(taskName);
        actions.forEach((action) -> {
            taskActions.remove(action);
            actionPrimitives.remove(action);
            tracker.remove(action);
            primitiveActionRelation.forEach((primitive, actionName) -> {
                if (actionName.equals(action)) {
                    primitiveActionRelation.remove(primitive);
                }
            });
        });
    }

}
