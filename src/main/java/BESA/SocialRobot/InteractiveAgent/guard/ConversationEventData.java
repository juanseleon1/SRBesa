package BESA.SocialRobot.InteractiveAgent.guard;

import rational.data.InfoData;

public class ConversationEventData extends InfoData{
    
    private String userId;
    private int queryId;
    private String origin;
    private String answer;
    private boolean isQueryAnswer;
    private boolean robotIsTalking;
    private boolean robotStatusSent;

    public ConversationEventData() {
        super("ConversationEventData");
        isQueryAnswer = false;
        robotIsTalking = false;
        robotStatusSent = false;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
        isQueryAnswer = true;
    }
    public boolean isQueryAnswer() {
        return isQueryAnswer;
    }
    public void setQueryAnswer(boolean isQueryAnswer) {
        this.isQueryAnswer = isQueryAnswer;
    }

    public int getQueryId(){
        return queryId;
    }
    public void setQueryId(int queryId){
        this.queryId = queryId;
    }
    public boolean isRobotIsTalking() {
        return robotIsTalking;
    }
    public void setRobotIsTalking(boolean robotIsTalking) {
        this.robotIsTalking = robotIsTalking;
    }
    public boolean isRobotStatusSent() {
        return robotStatusSent;
    }
    public void setRobotStatusSent(boolean robotStatusSent) {
        this.robotStatusSent = robotStatusSent;
    }
    
}
