package BESA.SocialRobot.ServiceProvider.services.robotresources;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class ResourceService extends SRService<ResourceServiceConfig>{

    public ResourceService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, ResourceServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
