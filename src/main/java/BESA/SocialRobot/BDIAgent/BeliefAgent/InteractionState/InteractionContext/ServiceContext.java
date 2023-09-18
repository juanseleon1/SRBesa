
package BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext;

import java.util.ArrayList;
import java.util.List;


public abstract class ServiceContext{
    private boolean isActive;
    private List<Double> relatedUsers;

    //TODO: This should be interfaced so it can be created once by service when executed.
    public ServiceContext() {
        relatedUsers = new ArrayList<>();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Double> getUserIDs() {
        return relatedUsers;
    }

    public void registerUser(double userID) {
        relatedUsers.add(userID);
    }

    public void unregisterUser(double userID) {
        relatedUsers.remove(userID);
    }

}
