package BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context;

import java.time.LocalDateTime;

public class SocioDemographicalContext {
    private String name;
    private String lastName;
    private String id;
    private LocalDateTime birthday;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDateTime getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
    
    
}
