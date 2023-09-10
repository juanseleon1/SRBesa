package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Configuration.UserConfiguration;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.UserContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Personalization.UserPersonalization;
import rational.data.InfoData;
import rational.mapping.Believes;

public class UserProfile implements Believes {

    private UserConfiguration userConf;
    private UserContext userContext;
    private UserPersonalization personalization;

    @Override
    public boolean update(InfoData data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

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
