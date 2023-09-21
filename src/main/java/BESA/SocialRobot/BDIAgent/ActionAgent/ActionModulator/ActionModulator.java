package BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;

public class ActionModulator {
    private EmotionalStateData lastEmotionalStateData;
    private EmotionalStateData maskApplied;
    private EnrichmentStrategy enrichmentStrategy;

    public ActionModulator(EnrichmentStrategy enrichmentStrategy) {
        this.enrichmentStrategy = enrichmentStrategy;
    }

    public EmotionalStateData getLastEmotionalStateData() {
        return lastEmotionalStateData;
    }

    public void setLastEmotionalStateData(EmotionalStateData lastEmotionalStateData) {
        this.lastEmotionalStateData = lastEmotionalStateData;
    }

    public EnrichmentStrategy getEnrichmentStrategy() {
        return enrichmentStrategy;
    }

    public void setEnrichmentStrategy(EnrichmentStrategy enrichmentStrategy) {
        this.enrichmentStrategy = enrichmentStrategy;
    }

    public ActionRequestData enrichActionRequestData(ActionRequestData actionRequestData) {
        EmotionalStateData dataToApply = lastEmotionalStateData;
        if(maskApplied != null){
            dataToApply = enrichmentStrategy.applyMaskToEmotions(lastEmotionalStateData, maskApplied);
        }
        return enrichmentStrategy.enrichActionRequestData(actionRequestData, dataToApply);
    }

}
