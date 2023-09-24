package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel;

import java.util.HashSet;
import java.util.Set;

public class Primitive {
    String name;
    Set<Parameter> parameters;

    public Primitive(String name) {
        this.name = name;
        parameters = new HashSet<>();
    }

    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    public String getName() {
        return name;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

}
