package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync;

import java.util.List;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.guards.InformationFlowGuard;
import rational.mapping.Plan;
import rational.mapping.Task;

public class SyncTaskGuard extends GuardBESA {
    // Invocked by SyncActionGuard when an action is done it removes actions from
    // the task context.
    @Override
    public void funcExecGuard(EventBESA event) {
        ReportBESA.debug("SyncTaskGuard");
        StateBDI state = (StateBDI) this.getAgent().getState();
        Plan plan = state.getMainRole().getRolePlan();
        List<Task> activeTasks = plan.getTasksInExecution();
        ReportBESA.debug("activeTasks " + activeTasks.size());
        SyncTaskActionData data = (SyncTaskActionData) event.getData();
        ReportBESA.debug("SyncTaskActionData " + data);
        boolean shouldTrigger = false;
        for (Task task : activeTasks) {
            ReportBESA.debug("Activetask " + task.getClass().getName());
            if (task instanceof SRTask && task.getClass().getName().equalsIgnoreCase(data.getTaskName())) {
                ReportBESA.debug("Removing action " + data.getActionId());
                SRTask srTask = (SRTask) task;
                srTask.removeAction(data.getActionId());
                shouldTrigger = shouldTrigger || srTask.checkFinish(state.getBelieves());
            }
        }

        if (shouldTrigger) {
            try {
                ReportBESA.debug("Triggering");
                PingData pingData = new PingData();
                EventBESA eventBesa = new EventBESA(InformationFlowGuard.class.getName(),
                        pingData);
                AgHandlerBESA agHandlerBESA;
                agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
                agHandlerBESA.sendEvent(eventBesa);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }
        }
    }

}