package BESA.SocialRobot.UserEmotionalInterpreterAgent.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;

public abstract class UserEmotionalInterpreterState extends StateBESA {
    private Map<Float, UserEmotionalModel> userModels;

    public UserEmotionalInterpreterState() {
        this.userModels = new HashMap<>();
    }

    public Map<Float, UserEmotionalModel> getUserModels() {
        return userModels;
    }

    public List<UserEmotion> calculateCompositeEmotions(float id){
        return this.userModels.get(id).calculateCompositeEmotions();
    }
 
    
    public void addUserModel(Float id, UserEmotionalModel model) {
        this.userModels.put(id, model);
    }

    public boolean isUserModelPresent(Float id) {
        return this.userModels.containsKey(id);
    }

    public void removeUserModel(Float id) {
        UserEmotionalModel model = this.userModels.remove(id);
        model.persist();
    }

    public abstract UserEmotionalModel retrievEmotionalModel(float id);
}
