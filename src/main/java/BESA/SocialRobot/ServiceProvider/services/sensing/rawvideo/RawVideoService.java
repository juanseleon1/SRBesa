package BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class RawVideoService extends SRService<RawVideoServiceConfig>{

    public RawVideoService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, RawVideoServiceConfig config) {
        super(name, adapter,receiver, config);
    }
    
}
