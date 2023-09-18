package BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class SentimentAnalysisService extends SRService<SentimentAnalysisServiceConfig>{

    public SentimentAnalysisService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, SentimentAnalysisServiceConfig config) {
        super(name, adapter,receiver, config);
    }
    
}
