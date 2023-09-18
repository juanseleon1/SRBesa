package BESA.SocialRobot.agentUtils;

import java.util.Map;

import rational.services.ActivateServiceData;

/**
 *
 * @author juans
 */
public class ServiceDataRequest extends ActivateServiceData {

    private int id;
    private String function;
    private Map<String, ?> params;

    public ServiceDataRequest(int id, String service, String function, Map<String, ?> params) {

        super(service);
        this.id = id;
        this.function = function;
        this.params = params;

    }

    public Map<String, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, ?> params) {
        this.params = params;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }


    public int getId() {
        return id;
    }
}
