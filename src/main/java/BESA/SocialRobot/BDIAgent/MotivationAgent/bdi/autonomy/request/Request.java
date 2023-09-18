package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request;

import java.time.LocalDateTime;
import java.util.Objects;

public class Request {
    private String name;
    private String userName;
    private String userId;
    private LocalDateTime originalTime;
    private LocalDateTime timestamp;
    private RequestStatus status;

    public Request(String name, String userName, String userId) {
        this.name = name;
        this.timestamp = LocalDateTime.now();
        this.originalTime = LocalDateTime.now();
        this.status = RequestStatus.SOLICITED;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void renew() {
        this.timestamp =  LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;

        Request Request = (Request) o;

        return name.equals(Request.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, originalTime);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
