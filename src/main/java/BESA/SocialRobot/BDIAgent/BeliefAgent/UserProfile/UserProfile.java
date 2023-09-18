package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Configuration.UserConfiguration;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.UserContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Personalization.UserPersonalization;
import rational.mapping.Believes;

public abstract class UserProfile implements Believes {
    //TODO: define what to do with this class.
    private UserConfiguration userConf;
    private UserContext userContext;
    private UserPersonalization personalization;

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public UserConfiguration getUserConf() {
        return userConf;
    }

    public void setUserConf(UserConfiguration userConf) {
        this.userConf = userConf;
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    public UserPersonalization getPersonalization() {
        return personalization;
    }

    public void setPersonalization(UserPersonalization personalization) {
        this.personalization = personalization;
    }

}
