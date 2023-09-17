package BESA.SocialRobot.ServiceProvider.services.interfaces.tabletevent;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class TabletEventService extends SRService<TabletEventServiceConfig>{

    public TabletEventService(String name, AdapterBESA adapter, TabletEventServiceConfig config) {
        super(name, adapter, config);
    }
    
}
