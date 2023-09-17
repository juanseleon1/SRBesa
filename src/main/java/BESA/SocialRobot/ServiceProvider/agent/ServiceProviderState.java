package BESA.SocialRobot.ServiceProvider.agent;

import BESA.Kernel.Social.ServiceProvider.agent.ServiceProviderDescriptor;
import BESA.Kernel.Social.ServiceProvider.agent.StateServiceProvider;

public class ServiceProviderState extends StateServiceProvider {

    private ServiceRequestManager manager;

    public ServiceProviderState(ServiceProviderDescriptor descriptor) {
        super(descriptor);
        manager = new ServiceRequestManager();
    }

    public ServiceRequestManager getRequestManager() {
        return manager;
    }

    public boolean hasRequestPending(int id) {
        return manager.hasRequestPending(id);
    }

    public void addRequest(int id) {
        manager.addRequest(id);
    }

    public void requestCompleted(int id) {
        manager.requestCompleted(id);
    }
}
