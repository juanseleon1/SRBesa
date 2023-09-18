package BESA.SocialRobot.ServiceProvider.services.interfaces.interfaceevent;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class InterfaceEventService extends SRService<InterfaceEventServiceConfig>{

    public InterfaceEventService(ServiceNames name, SRAdapter adapter, SRAdapterReceiver receiver, InterfaceEventServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
