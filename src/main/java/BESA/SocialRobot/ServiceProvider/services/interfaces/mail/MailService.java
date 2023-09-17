package BESA.SocialRobot.ServiceProvider.services.interfaces.mail;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class MailService extends SRService<MailServiceConfig>{

    public MailService(String name, AdapterBESA adapter, MailServiceConfig config) {
        super(name, adapter, config);
    }
    
}
