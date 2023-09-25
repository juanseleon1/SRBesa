package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import java.util.HashMap;
import java.util.Map;

public class Resource {
    private static long idGenerator = 0;
    private long id;
    private String name;
    private Map<String, Map<String, String>> parameters;

    public Resource() {
        parameters = new HashMap<>();
    }

    public Resource(String name, Map<String, Map<String, String>> parameters) {
        this.id = generateId();
        this.name = name;
        this.parameters = parameters;
    }

    private static long generateId() {
        return idGenerator++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Map<String, String>> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Map<String, String>> parameters) {
        this.parameters = parameters;
    }

}
