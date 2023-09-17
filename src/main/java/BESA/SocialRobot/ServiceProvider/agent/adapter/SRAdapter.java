package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Adapter.AdapterBESA;

/**
 *
 * @author juans
 */
public abstract class SRAdapter extends AdapterBESA {

    protected SRAdapter() {
        super(null, null);
    }

    public abstract void sendRequest(RobotData data);
}
