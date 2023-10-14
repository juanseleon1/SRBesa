
package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext;

import java.util.ArrayList;
import java.util.List;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;
import rational.mapping.Believes;

public abstract class ServiceContext implements Believes {
    private boolean isActive;
    private List<String> relatedUsers;

    public ServiceContext() {
        relatedUsers = new ArrayList<>();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getUserIDs() {
        return relatedUsers;
    }

    public void registerUser(String userID) {
        relatedUsers.add(userID);
    }

    public void unregisterUser(String userID) {
        relatedUsers.remove(userID);
    }

    public List<String> getRelatedUsers() {
        return relatedUsers;
    }

    public void setRelatedUsers(List<String> relatedUsers) {
        this.relatedUsers = relatedUsers;
    }

    @Override
    public boolean update(InfoData data) {
        boolean isUpdated = false;
        if (data instanceof RobotData) {
            isUpdated = handleRobotData((RobotData) data);
        } else {
            isUpdated = handleOtherData(data);
        }
        return isUpdated;
    }

    @Override
    public abstract ServiceContext clone();

    public abstract boolean handleRobotData(RobotData data);

    public abstract boolean handleOtherData(InfoData data);

    public abstract String captureRecordData();

}
