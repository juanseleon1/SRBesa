package BESA.SocialRobot.RiskDetectionAgent.agent;

import java.util.Map;

import BESA.Kernel.Agent.Event.DataBESA;

public class RawVideoData extends DataBESA{
    //When this is changed, you should update this to receive video feed.
    private String userId;
    private Map<String, Object> params;
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Map<String, Object> getParams() {
        return params;
    }
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    
}
