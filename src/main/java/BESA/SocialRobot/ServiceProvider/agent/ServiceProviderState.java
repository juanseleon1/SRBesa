package BESA.SocialRobot.ServiceProvider.agent;

import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDescriptor;
import BESA.Kernel.Social.ServiceProvider.agent.StateServiceProvider;

public class ServiceProviderState extends StateServiceProvider {

    private ServiceRequestManager<Double> manager;

    public ServiceProviderState(ServiceProviderDescriptor descriptor) {
        super(descriptor);
        manager = new ServiceRequestManager<>();
    }

    public ServiceRequestManager<Double>  getRequestManager() {
        return manager;
    }

    public boolean hasRequestPending(double id) {
        return manager.hasRequestPending(id);
    }
    public void addRequest(double id) {
        manager.addRequest(id);
    }

    public void requestCompleted(double id) {
        manager.requestCompleted(id);
    }
}
