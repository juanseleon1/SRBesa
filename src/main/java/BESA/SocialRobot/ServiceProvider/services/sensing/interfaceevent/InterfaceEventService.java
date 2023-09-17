package BESA.SocialRobot.ServiceProvider.services.sensing.interfaceevent;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class InterfaceEventService extends SRService<InterfaceEventServiceConfig>{

    public InterfaceEventService(String name, AdapterBESA adapter, InterfaceEventServiceConfig config) {
        super(name, adapter, config);
    }
    
}
