package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard.SyncActionGuard;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EnrichActionGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.ActionRequestBuilder;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.ParameterBundle;
import rational.mapping.Believes;
import rational.mapping.Task;

public abstract class SRTask extends Task {
    private TaskContext context;

    public static enum TaskRequestType {
        CANCEL, INTERRUPT
    }

    public SRTask() {
        this.context = new TaskContext();
    }

    @Override
    public void cancelTask(Believes beliefs) {
        sendTaskStatusUpdateRequest(TaskRequestType.CANCEL);
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        return context.isTaskDone();
    }

    @Override
    public void interruptTask(Believes beliefs) {
        sendTaskStatusUpdateRequest(TaskRequestType.INTERRUPT);
    }

    protected void sendActionRequest(ParameterBundle params, String name) {
        try {
            ActionRequestData action = ActionRequestBuilder.getActionRequestData(params, name,
                    this.getClass().getName());
            context.addAction(action);
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
            EventBESA sensorEvtA = new EventBESA(EnrichActionGuard.class.getName(), action);
            handler.sendEvent(sensorEvtA);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    protected void sendTaskStatusUpdateRequest(TaskRequestType status) {
        try {
            ActionRequestData action = ActionRequestBuilder.getActionRequestData(status.name(),
                    this.getClass().getName());
            AgHandlerBESA handler = AdmBESA.getInstance().getHandlerByAlias(ActionAgent.name);
            EventBESA sensorEvtA = new EventBESA(SyncActionGuard.class.getName(), action);
            handler.sendEvent(sensorEvtA);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
