package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Parameter {
    private String name;
    private Map<String, String> config;

    public Parameter() {
        config = new ConcurrentHashMap<>();
    }

    public Parameter(String name) {
        this.name = name;
        config = new ConcurrentHashMap<>();
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

    @Override
    public String toString() {
        return "Parameter [name=" + name + ", config=" + config + "]";
    }

}
