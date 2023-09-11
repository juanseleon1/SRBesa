package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Configuration;

public class UserConfiguration  {
    private EmotionalModelParams emoParams;
    private VoiceModelParams voiceParams;

    public UserConfiguration() {

    }

    public EmotionalModelParams getEmoParams() {
        return emoParams;
    }

    public void setEmoParams(EmotionalModelParams emoParams) {
        this.emoParams = emoParams;
    }

    public VoiceModelParams getVoiceParams() {
        return voiceParams;
    }

    public void setVoiceParams(VoiceModelParams voiceParams) {
        this.voiceParams = voiceParams;
    }
}
