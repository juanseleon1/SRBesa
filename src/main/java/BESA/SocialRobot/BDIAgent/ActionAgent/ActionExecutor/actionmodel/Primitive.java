package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel;

import java.util.HashSet;
import java.util.Set;

public class Primitive {
    private String name;
    private Set<Parameter> parameters;
    private String service;
    private String function;

    public Primitive() {
        parameters = new HashSet<>();
    }

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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Primitive [name=" + name + ", parameters=" + parameters + ", service=" + service + ", function="
                + function + "]";
    }

}
