package BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class RawVideoService extends SRService<RawVideoServiceConfig>{

    public RawVideoService(String name, AdapterBESA adapter, RawVideoServiceConfig config) {
        super(name, adapter, config);
    }
    
}
