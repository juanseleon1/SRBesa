package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

public class UserEmotion {
    private String name;
    private float intensity;

    public UserEmotion(String name, float intensity) {
        this.name = name;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }

}
