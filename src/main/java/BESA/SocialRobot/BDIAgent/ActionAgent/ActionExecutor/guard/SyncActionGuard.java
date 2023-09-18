package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.SyncActionData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync.SyncTaskGuard;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;

public class SyncActionGuard extends GuardBESA {
    //It is consumed by the serviceproviders 
    // if all actions of a task are done, then the SynctaskGuard is invocked.

    @Override
    public void funcExecGuard(EventBESA event) {
        try {
            RobotReplyData data = (RobotReplyData)event.getData();
            //TODO: add coordination and task checking
            SyncActionData syncData = new SyncActionData();
            EventBESA eventBesa = new EventBESA(SyncTaskGuard.class.getName(), syncData);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

}
