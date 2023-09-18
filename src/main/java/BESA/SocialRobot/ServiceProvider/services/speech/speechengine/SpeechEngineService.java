package BESA.SocialRobot.ServiceProvider.services.speech.speechengine;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class SpeechEngineService extends SRService<SpeechEngineServiceConfig>{

    public SpeechEngineService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, SpeechEngineServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
