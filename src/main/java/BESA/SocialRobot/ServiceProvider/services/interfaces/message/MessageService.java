package BESA.SocialRobot.ServiceProvider.services.interfaces.message;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class MessageService extends SRService<MessageServiceConfig>{

    public MessageService(String name, AdapterBESA adapter, MessageServiceConfig config) {
        super(name, adapter, config);
    }
    
}
