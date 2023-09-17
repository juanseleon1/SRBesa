package BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class SentimentAnalysisService extends SRService<SentimentAnalysisServiceConfig>{

    public SentimentAnalysisService(String name, AdapterBESA adapter, SentimentAnalysisServiceConfig config) {
        super(name, adapter, config);
    }
    
}
