package BESA.SocialRobot.ServiceProvider.agent;

import java.util.HashSet;
import java.util.Set;

public class ServiceRequestManager {
    private Set<Integer> pendingRequests;

    public ServiceRequestManager() {
        pendingRequests = new HashSet<>();
    }

    public boolean hasRequestPending(int id) {
        return pendingRequests.contains(id);
    }

    public void addRequest(int id) {
        pendingRequests.add(id);
    }

    public void requestCompleted(int id) {
        pendingRequests.remove(id);
    }

}
