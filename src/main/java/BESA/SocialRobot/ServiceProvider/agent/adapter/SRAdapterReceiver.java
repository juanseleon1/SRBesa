package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.ServiceProvider.agent.guard.ProcessRobotReplyGuard;

/**
 *
 * @author juans
 * @param <T>
 */
public abstract class SRAdapterReceiver {
    private boolean hasStarted;
    private String spAlias;

    public SRAdapterReceiver(String spAlias) {
        this.spAlias = spAlias;
        hasStarted = false;
    }

    protected void handleRobotData(RobotData rd) throws ExceptionBESA {
        AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(spAlias);
        EventBESA evSP = new EventBESA(ProcessRobotReplyGuard.class.getName(), rd);
        agH.sendEvent(evSP);
    }

    public void startReceiver(){
        if(!hasStarted){
            this.setup();
            hasStarted = true;
        }
    }

    public abstract void setup();

}
