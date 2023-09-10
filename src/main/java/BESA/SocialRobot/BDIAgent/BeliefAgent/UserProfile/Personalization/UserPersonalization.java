package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Personalization;

public class UserPersonalization {
    private SkillParameters skillParameters;
    private ServiceParameters serviceParameters;
    private InterfaceParameters interfaceParameters;

    public SkillParameters getSkillParameters() {
        return skillParameters;
    }

    public void setSkillParameters(SkillParameters skillParameters) {
        this.skillParameters = skillParameters;
    }

    public ServiceParameters getServiceParameters() {
        return serviceParameters;
    }

    public void setServiceParameters(ServiceParameters serviceParameters) {
        this.serviceParameters = serviceParameters;
    }

    public InterfaceParameters getInterfaceParameters() {
        return interfaceParameters;
    }

    public void setInterfaceParameters(InterfaceParameters interfaceParameters) {
        this.interfaceParameters = interfaceParameters;
    }

}
