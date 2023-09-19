package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.SyncTaskActionData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.SyncTaskGuard;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;

public class SyncActionGuard extends GuardBESA {
    // It is consumed by the serviceproviders
    // if all actions of a task are done, then the SyncTaskGuard is invocked.

    @Override
    public void funcExecGuard(EventBESA event) {
        try {
            ActionAgentState state = (ActionAgentState) this.getAgent().getState();
            RobotReplyData data = (RobotReplyData) event.getData();
            state.getActionExecutor().primitiveDoneForAction(data.getAction(), data.getPrimitiveId());
            if (state.getActionExecutor().checkActionIsDone(data.getAction())) {
                String task = state.getActionExecutor().getTaskForAction(data.getAction());
                state.getActionExecutor().deleteAction(data.getAction());
                SyncTaskActionData syncData = new SyncTaskActionData(data.getAction(), task);
                EventBESA eventBesa = new EventBESA(SyncTaskGuard.class.getName(), syncData);
                AgHandlerBESA agHandlerBESA;
                agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
                agHandlerBESA.sendEvent(eventBesa);
            }
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
