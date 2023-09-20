
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import java.io.FileNotFoundException;
import java.util.List;

import BESA.Exception.ExceptionBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalModel;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.EmotionalModelDescriptors;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.LoadEmotionalModelConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.SemanticDictionaryDescriptor;

public class AgentEmotionalState extends EmotionalModel {

    private List<Mask> availableMasks;
    private String semanticDictPath;
    private String characterDescPath;
    private RobotEmotionalStrategy emotionalStrategy;
    private EmotionalStateData latestEmoData;
    public AgentEmotionalState(String semanticDictPath, String characterDescPath, RobotEmotionalStrategy emotionalStrategy) {
        this.semanticDictPath = semanticDictPath;
        this.characterDescPath = characterDescPath;
        this.emotionalStrategy = emotionalStrategy;
    }

    @Override
    public void emotionalStateChanged() {
        try {
            EmotionalStateData data = emotionalStrategy.processEmotionsForRobot(this);
            latestEmoData=data;
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
        // Axis are loaded with the characterDescriptor.
    }

    public List<Mask> getAvailableMasks() {
        return availableMasks;
    }

    public void setAvailableMasks(List<Mask> availableMasks) {
        this.availableMasks = availableMasks;
    }

    public EmotionalStateData getRobotEmotionalState(){
        return latestEmoData;
    }

}
