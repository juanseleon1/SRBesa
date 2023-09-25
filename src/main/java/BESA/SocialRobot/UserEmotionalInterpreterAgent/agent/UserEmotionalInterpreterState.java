package BESA.SocialRobot.UserEmotionalInterpreterAgent.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;

public abstract class UserEmotionalInterpreterState extends StateBESA {
    private Map<String, UserEmotionalModel> userModels;

    public UserEmotionalInterpreterState() {
        this.userModels = new HashMap<>();
    }

    public Map<String, UserEmotionalModel> getUserModels() {
        return userModels;
    }

    public List<UserEmotion> calculateCompositeEmotions(String id){
        return this.userModels.get(id).calculateCompositeEmotions();
    }
 
    
    public void addUserModel(String id, UserEmotionalModel model) {
        this.userModels.put(id, model);
    }

    public boolean isUserModelPresent(String id) {
        return this.userModels.containsKey(id);
    }

    public void removeUserModel(String id) {
        UserEmotionalModel model = this.userModels.remove(id);
        model.persist();
    }

    public abstract UserEmotionalModel retrieveEmotionalModel(String id);
}
