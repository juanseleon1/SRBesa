package BESA.SocialRobot.agentUtils;

import java.util.Map;

import rational.services.ActivateServiceData;


public class ServiceDataRequest extends ActivateServiceData {

    private double id;
    private String function;
    private Map<String, Object> params;
    private boolean isFromInteractionAgent;
    private boolean cancelAction;

    public ServiceDataRequest(double id, String service, String function, Map<String, Object> params) {

        super(service);
        this.id = id;
        this.function = function;
        this.params = params;
        isFromInteractionAgent = false;
        this.cancelAction = false;
    }

    public ServiceDataRequest(double id) {
        super(null);
        this.id = id;
        isFromInteractionAgent = false;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ServiceDataRequest) {
            ServiceDataRequest sdr = (ServiceDataRequest) obj;
            return sdr.getId() == this.id;
        }
        return false;
    }

    public boolean isCancelAction() {
        return cancelAction;
    }

    public void setCancelAction(boolean cancelAction) {
        this.cancelAction = cancelAction;
    }

    public static ServiceDataRequest buildCancelRequest(ServiceDataRequest primitive) {
        ServiceDataRequest cancelRequest = new ServiceDataRequest(primitive.getId(), primitive.getServiceName(), primitive.getFunction(), primitive.getParams());
        cancelRequest.setCancelAction(true);
        return cancelRequest;
    }

    @Override
    public String toString() {
        return "ServiceDataRequest [id=" + id + ", function=" + function + ", params=" + params
                + ", isFromInteractionAgent=" + isFromInteractionAgent + ", cancelAction=" + cancelAction + "]";
    }
    

    
}
