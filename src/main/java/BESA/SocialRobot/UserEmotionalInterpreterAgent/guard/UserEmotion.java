package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

public class UserEmotion {
    private String name;
    private double intensity;

    public UserEmotion(String name, double intensity) {
        this.name = name;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "UserEmotion [name=" + name + ", intensity=" + intensity + "]";
    }
}
