package BESA.SocialRobot.ServiceProvider.services.interfaces.message;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class MessageService extends SRService<MessageServiceConfig>{

    public MessageService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, MessageServiceConfig config) {
        super(name, adapter,receiver, config);
    }
    
}
