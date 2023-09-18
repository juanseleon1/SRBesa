package BESA.SocialRobot.agentUtils;

import java.util.Map;

import rational.services.ActivateServiceData;

/**
 *
 * @author juans
 */
public class ServiceDataRequest extends ActivateServiceData {

    private double id;
    private String function;
    private Map<String, ?> params;
    private boolean isFromInteractionAgent;

    public ServiceDataRequest(double id, String service, String function, Map<String, ?> params) {

        super(service);
        this.id = id;
        this.function = function;
        this.params = params;
        isFromInteractionAgent = false;
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


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public boolean isFromInteractionAgent() {
        return isFromInteractionAgent;
    }

    public void setFromInteractionAgent(boolean fromInteractionAgent) {
        isFromInteractionAgent = fromInteractionAgent;
    }
}
