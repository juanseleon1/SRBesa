
package BESA.SocialRobot.EmotionalInterpreterAgent.guard;

import java.util.Map;

import BESA.Kernel.Agent.Event.DataBESA;

public class EmotionalData extends DataBESA {
    //This one goes to the emotional interpreter agent
    String origin;
    String action;
    Map<String, Double> emoParams;
    
    public EmotionalData(Map<String, Double> emoParams) {
        this.emoParams = emoParams;
    }

    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public Map<String, Double> getEmoInfo() {
        return emoParams;
    }

    public void setEmoInfo(Map<String, Double> emoParams) {
        this.emoParams = emoParams;
    }

    public Map<String, Double> getEmoParams() {
        return emoParams;
    }
}
