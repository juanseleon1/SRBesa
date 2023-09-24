package BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class LoadEmotionalModelConfig{

    public static SemanticDictionaryDescriptor decodeYamlSemanticDictionary(String filePath) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(filePath));
        Constructor constructor = new Constructor(SemanticDictionaryDescriptor.class,new LoaderOptions());
        TypeDescription d = new TypeDescription(SemanticDictionaryDescriptor.class);
        d.addPropertyParameters("persons", String.class, String.class);
        d.addPropertyParameters("events", String.class, String.class);
        d.addPropertyParameters("objects", String.class, String.class);
        constructor.addTypeDescription(d);
        Yaml yaml = new Yaml(constructor);
        SemanticDictionaryDescriptor p = (SemanticDictionaryDescriptor) yaml.load(is);
        return p;
    }

    public static EmotionalModelDescriptors decodeYamlEmotionalModelDescriptor(String filePath) throws FileNotFoundException {

        InputStream is = new FileInputStream(new File(filePath));
        Constructor constructor = new Constructor(EmotionalModelDescriptors.class, new LoaderOptions());
        TypeDescription d = new TypeDescription(EmotionalModelDescriptors.class);
        d.addPropertyParameters("personRelationships", String.class, String.class);
        d.addPropertyParameters("eventDesirabilitys", String.class, String.class);
        d.addPropertyParameters("objectRelationships", String.class, String.class);
        d.addPropertyParameters("emotionalAxis", EmotionalAxisDescriptor.class);
        constructor.addTypeDescription(d);
        TypeDescription d2 = new TypeDescription(EmotionalAxisDescriptor.class);
        d2.addPropertyParameters("eventInfluences", String.class, String.class);
        constructor.addTypeDescription(d2);
        Yaml yaml = new Yaml(constructor);
        EmotionalModelDescriptors p = (EmotionalModelDescriptors) yaml.load(is);
        return p;
    }

}
