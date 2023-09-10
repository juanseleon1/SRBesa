package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context;

public class UserContext {
    private MedicalContext medicalContext;
    private PreferenceContext preferenceContext;
    private SocioDemographicalContext socioDemoContext;

    public MedicalContext getMedicalContext() {
        return medicalContext;
    }

    public void setMedicalContext(MedicalContext medicalContext) {
        this.medicalContext = medicalContext;
    }

    public PreferenceContext getPreferenceContext() {
        return preferenceContext;
    }

    public void setPreferenceContext(PreferenceContext preferenceContext) {
        this.preferenceContext = preferenceContext;
    }

    public SocioDemographicalContext getSocioDemoContext() {
        return socioDemoContext;
    }

    public void setSocioDemoContext(SocioDemographicalContext socioDemoContext) {
        this.socioDemoContext = socioDemoContext;
    }

}
