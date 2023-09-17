package BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class EmotionExtractorService extends SRService<EmotionExtractorServiceConfig>{

    public EmotionExtractorService(String name, AdapterBESA adapter, EmotionExtractorServiceConfig config) {
        super(name, adapter, config);
    }
    
}
