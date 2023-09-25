package BESA.SocialRobot.ServiceProvider.agent.adapter;

import java.util.Map;

import rational.data.InfoData;

public class RobotData extends InfoData{
    private double id;
    private String service;
    private String function;
    private Map<String,?> parameters;

    public RobotData(double id, String service, String function, Map<String, ?> parameters) {
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

    public Map<String, ?> getParameters() {
        return parameters;
    }

}
