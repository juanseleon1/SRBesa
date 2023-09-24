package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel;

import java.util.HashMap;
import java.util.Map;

public class Parameter {
    String name;
    Map<String, String> config;

    public Parameter(String name) {
        this.name = name;
        config = new HashMap<>();
    }

    public void addConfig(String key, String value) {
        config.put(key, value);
    }

    public String getConfig(String key) {
        return config.get(key);
    }


    public String getName() {
        return name;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

}
