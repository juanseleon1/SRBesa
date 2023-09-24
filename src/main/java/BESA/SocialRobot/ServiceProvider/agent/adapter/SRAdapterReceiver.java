package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.ServiceProvider.agent.guard.ProcessRobotReplyGuard;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

/**
 *
 * @author juans
 * @param <T>
 */
public abstract class SRAdapterReceiver {
    private boolean hasStarted;
    private String spAlias;

    public SRAdapterReceiver() {
        hasStarted = false;
    }

    protected void handleRobotData(RobotReplyData rd) throws ExceptionBESA {
        AgHandlerBESA agH = AdmBESA.getInstance().getHandlerByAlias(spAlias);
        EventBESA evSP = new EventBESA(ProcessRobotReplyGuard.class.getName(), rd);
        agH.sendEvent(evSP);
    }

    public void startReceiver(ServiceNames spAlias){
        if(!hasStarted){
            this.spAlias = spAlias.name();
            this.setup();
            hasStarted = true;
        }
    }

    public abstract void setup();

}
