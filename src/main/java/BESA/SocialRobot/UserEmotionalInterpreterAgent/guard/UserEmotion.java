package BESA.SocialRobot.UserEmotionalInterpreterAgent.guard;

public class UserEmotion {
    private String name;
    private float degree;

    public UserEmotion(String name, float degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public float getDegree() {
        return degree;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(float degree) {
        this.degree = degree;
    }

}
