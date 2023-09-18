package BESA.SocialRobot.ServiceProvider.agent;

import java.util.HashSet;
import java.util.Set;

public class ServiceRequestManager<T> {
    private Set<T> pendingRequests;

    public ServiceRequestManager() {
        pendingRequests = new HashSet<>();
    }

    public boolean hasRequestPending(T id) {
        return pendingRequests.contains(id);
    }

    public void addRequest(T id) {
        pendingRequests.add(id);
    }

    public void requestCompleted(T id) {
        pendingRequests.remove(id);
    }

}
