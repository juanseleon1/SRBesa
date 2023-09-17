package BESA.SocialRobot.ServiceProvider.services.speech.speechengine;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class SpeechEngineService extends SRService<SpeechEngineServiceConfig>{

    public SpeechEngineService(String name, AdapterBESA adapter, SpeechEngineServiceConfig config) {
        super(name, adapter, config);
    }
    
}
