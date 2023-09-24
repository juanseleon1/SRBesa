
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionAxis;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalModel;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Personality;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.EmotionalModelDescriptors;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.LoadEmotionalModelConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.SemanticDictionaryDescriptor;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalImpact;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalAgentRole;

public class AgentEmotionalState extends EmotionalModel {

    private String semanticDictPath;
    private String characterDescPath;
    private RobotEmotionalStrategy emotionalStrategy;
    private EmotionalStateData latestEmoData;
    private EmotionalAgentRole origEmotionalAgentRole;

    public AgentEmotionalState(String semanticDictPath, String characterDescPath,
            RobotEmotionalStrategy emotionalStrategy) {
        this.semanticDictPath = semanticDictPath;
        this.characterDescPath = characterDescPath;
        this.emotionalStrategy = emotionalStrategy;
        this.configureEmotionalModel();
    }

    @Override
    public void emotionalStateChanged() {
        try {
            EmotionalStateData data = emotionalStrategy.processEmotionsForRobot(this);
            latestEmoData = data;
            sendToActionModulator(data);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadSemanticDictionary() {
        SemanticDictionaryDescriptor d;
        try {
            d = LoadEmotionalModelConfig.decodeYamlSemanticDictionary(semanticDictPath);
            d.validate(semanticDictPath);
            d.copyToGlobalSemanticDictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadCharacterDescriptor() {
        try {
            EmotionalModelDescriptors cd = LoadEmotionalModelConfig
                    .decodeYamlEmotionalModelDescriptor(characterDescPath);
            cd.applyEmotionalModelDescriptor(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadEmotionalAxes() {
        //Making a copy original emotional state
        try {
            List<EmotionalImpact> emotionalImpacts = new ArrayList<>();
            List<EmotionAxis> axes = this.getEmotionsListCopy();
            axes.forEach(axis -> {
                emotionalImpacts.add(new EmotionalImpact(axis.getEventInfluences(), axis.getForgetFactor(),
                        axis.getBaseValue()));
            });
            origEmotionalAgentRole = new EmotionalAgentRole(emotionalImpacts, getPersonality().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //Making a copy of the original Semantic Dictionary
    }

    public synchronized void applyAgentRole(EmotionalAgentRole mission){
        List<EmotionAxis> axes = this.getEmotionAxis();
        mission.getEmotionalImpacts().forEach(impact -> {
            EmotionAxis axis = axes.stream().filter(a -> a.getPositiveName().equals(impact.getPositiveEmotionName())).findFirst()
                    .orElse(null);
            if (axis != null) {
                axis.setBaseValue(impact.getBaseValue());
                axis.setForgetFactor(impact.getForgetFactor());
                axis.setEventInfluences(impact.getEventInfluences());
            }
        });
        Personality newPersonality = mission.getPersonality();
        newPersonality.getEventDesirability().forEach( (k,v) -> {
            setEventDesirability(k, v);
        });
        newPersonality.getObjectRelationships().forEach( (k,v) -> {
            setObjectRelationship(k, v);
        });
        newPersonality.getPersonRelationships().forEach( (k,v) -> {
            setPersonRelationship(k, v);
        });
        emotionalStateChanged();
    }

    public void resetAgentRole(){
        applyAgentRole(origEmotionalAgentRole);
    }

    public EmotionalStateData getRobotEmotionalState() {
        return latestEmoData;
    }

}
