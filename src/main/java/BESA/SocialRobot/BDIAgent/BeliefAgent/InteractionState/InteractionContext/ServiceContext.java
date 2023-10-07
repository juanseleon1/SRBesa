
package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext;

import java.util.ArrayList;
import java.util.List;

import rational.mapping.Believes;


public abstract class ServiceContext implements Believes{
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
    public abstract ServiceContext clone();

}
