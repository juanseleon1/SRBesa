package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class RequestHandler {
    private Map<String, Request> requests;
    private Map<String, Request> approvedRequests;
    private Timer timer = new Timer();
    private long cleanUpTime;

    public RequestHandler() {
        requests = new ConcurrentHashMap<>();
        approvedRequests = new ConcurrentHashMap<>();
        // Schedule a task to periodically remove expired requests
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cleanupExpiredRequests();
            }
        }, cleanUpTime); // Run every 10 minutes (10 * 60 * 1000 milliseconds)
    }

    public boolean addRequest(String name) {
        boolean isAdded = false;
        Request existingRequest = requests.get(name);
        if (existingRequest != null) {
            existingRequest.renew(); // Renew the existing request
        } else {
            // If not found, add a new request
            requests.put(name, new Request(name));
        }
        return isAdded;
    }

    public void approveRequest(String name) {
        Request request = requests.get(name);
        if (request != null) {
            request.setStatus(RequestStatus.APPROVED);
            approvedRequests.put(name, request);
            // Remove the approved request from the requests map
            requests.remove(name);
        }
    }

    public boolean isRequestGranted(String name) {
        return approvedRequests.containsKey(name);
    }

    public void removeGrantedRequest(String name) {
        approvedRequests.remove(name);
    }

    public void cleanupExpiredRequests() {
        LocalDateTime dateLimit = LocalDateTime.now().minus(10, ChronoUnit.MINUTES);;
        Iterator<Map.Entry<String, Request>> iterator = requests.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Request> entry = iterator.next();
            Request request = entry.getValue();
            if (request.getTimestamp().isBefore(dateLimit)) {
                iterator.remove(); 
            }
        }
    }
}
