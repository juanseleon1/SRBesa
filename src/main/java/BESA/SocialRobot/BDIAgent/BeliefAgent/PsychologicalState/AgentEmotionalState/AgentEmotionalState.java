/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState;

import java.io.FileNotFoundException;
import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalModel;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.EmotionalModelDescriptors;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.LoadEmotionalModelConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml.SemanticDictionaryDescriptor;


public class AgentEmotionalState extends EmotionalModel {

    private List<Mask> availableMasks;
    private String semanticDictPath = "";
    private String characterDescPath = "";

    public AgentEmotionalState() {

    }

    @Override
    public void emotionalStateChanged() {
        // TODO Get emotion values and send to Action Modulator.
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
        //Axis are loaded with the characterDescriptor.
    }

    public List<Mask> getAvailableMasks() {
        return availableMasks;
    }

    public void setAvailableMasks(List<Mask> availableMasks) {
        this.availableMasks = availableMasks;
    }

}
