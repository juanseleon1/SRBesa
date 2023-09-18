package BESA.SocialRobot.ServiceProvider.agent.adapter;

import java.util.Map;

public class RobotData {
    private int id;
    private String service;
    private String function;
    private Map<String,?> parameters;

    public RobotData(int id, String service, String function, Map<String, ?> parameters) {
        this.id = id;
        this.service = service;
        this.function = function;
        this.parameters = parameters;
    }

    public int getId() {
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
