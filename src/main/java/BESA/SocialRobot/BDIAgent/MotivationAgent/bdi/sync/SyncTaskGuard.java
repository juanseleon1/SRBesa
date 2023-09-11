package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.sync;


import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;

public class SyncTaskGuard extends GuardBESA {
    //Invocked by SyncActionGuard when an action is done
    //removes actions from the context.
    @Override
    public void funcExecGuard(EventBESA event) {
        //ActionRequestData infoRecibida = (ActionRequestData) event.getData();
        // TODO: Coordinate Action according to state
        //Get related task, get context, remove action. 
        //Remove action from context
    }

}