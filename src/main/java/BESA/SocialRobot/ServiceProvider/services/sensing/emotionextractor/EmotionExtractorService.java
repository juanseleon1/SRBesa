package BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class EmotionExtractorService extends SRService<EmotionExtractorServiceConfig>{

    public EmotionExtractorService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, EmotionExtractorServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
