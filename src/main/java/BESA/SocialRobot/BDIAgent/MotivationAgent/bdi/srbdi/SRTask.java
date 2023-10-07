package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi;

import java.util.Map;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.ProcessActionGuard;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EnrichActionGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.ChangeAgentRoleData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.ChangeAgentRoleGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.ActionRequestBuilder;
import rational.mapping.Believes;
import rational.mapping.Task;

public abstract class SRTask extends Task {
    protected TaskContext context;

    public static enum TaskRequestType {
        CANCEL, INTERRUPT
    }

    public SRTask(TaskContext context) {
        this.context = context;
    }

    public SRTask() {
        this.context = new TaskContext();
    }

    @Override
    public synchronized void setTaskWaitingForExecution() {
        super.setTaskWaitingForExecution();
        context.removeAllActions();
    }

    @Override
    public void cancelTask(Believes beliefs) {
        sendTaskStatusUpdateRequest(TaskRequestType.CANCEL);
        removeAllActions();
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        ReportBESA.debug("checking context"+context);
        ReportBESA.debug("Checking finish "+this.isInExecution()+" contextDone"+context.isTaskDone());
        return this.isInExecution() && context.isTaskDone();
    }

    @Override
    public void interruptTask(Believes beliefs) {
        sendTaskStatusUpdateRequest(TaskRequestType.INTERRUPT);
        removeAllActions();
    }

    public void removeAction(String actionId) {
        ReportBESA.debug("Removing action "+actionId+" Context is "+ context);
        context.removeAction(actionId);
    }

    public void removeAllActions() {
        context.removeAllActions();
    }

    protected void sendActionRequest(Map<String, Object> params, String name) {
        try {
            ReportBESA.debug("Sending action request: " + name);
            ActionRequestData action = ActionRequestBuilder.buildActionRequest(params, name,
                    this.getClass().getName());
            context.addAction(action);
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
            EventBESA evtBesa = new EventBESA(EnrichActionGuard.class.getName(), action);
            handler.sendEvent(evtBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    protected void sendTaskStatusUpdateRequest(TaskRequestType status) {
        try {
            ActionRequestData action = ActionRequestBuilder.buildActionRequest(status.name(),
                    this.getClass().getName());
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
            EventBESA evtBesa = new EventBESA(ProcessActionGuard.class.getName(), action);
            handler.sendEvent(evtBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    protected void sendAgentRoleChange(AgentRole mission) {
        try {
            ChangeAgentRoleData data = new ChangeAgentRoleData(mission);
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            EventBESA evtBesa = new EventBESA(ChangeAgentRoleGuard.class.getName(), data);
            handler.sendEvent(evtBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
