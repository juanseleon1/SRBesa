package BESA.SocialRobot.ServiceProvider.agent.adapter;

import java.util.Map;

import rational.data.InfoData;

public class RobotData extends InfoData{
    private double id;
    private String service;
    private String function;
    private Map<String, Object> parameters;

    

    public RobotData() {
        super(null);
    }

    public RobotData(double id, String service, String function, Map<String, Object> parameters) {
        super("null");
        this.id = id;
        this.service = service;
        this.function = function;
        this.parameters = parameters;
    }

    public double getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public String getFunction() {
        return function;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    

    @Override
    public String toString() {
        return "RobotData [id=" + id + ", service=" + service + ", function=" + function + ", parameters=" + parameters
                + "]";
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
