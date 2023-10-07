package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Adapter.AdapterBESA;


public abstract class SRAdapter extends AdapterBESA {
    private boolean hasStarted;
    protected SRAdapter() {
        super(null, null);
        hasStarted = false;
    }
    public void startAdapter(){
        if(!hasStarted){
            this.setup();
            hasStarted = true;
        }
    }
    public abstract void setup();
    public abstract void sendRequest(RobotData data);
}
