package BESA.SocialRobot.ServiceProvider.services.interfaces.mail;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class MailService extends SRService<MailServiceConfig>{

    public MailService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, MailServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
