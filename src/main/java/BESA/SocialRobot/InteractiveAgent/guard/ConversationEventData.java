package BESA.SocialRobot.InteractiveAgent.guard;

import rational.data.InfoData;

public class ConversationEventData extends InfoData{
    
    private float id;
    private int queryId;
    private String origin;
    private String answer;
    private boolean isQueryAnswer;
    public ConversationEventData() {
        super("ConversationEventData");
        isQueryAnswer = false;
    }
    public float getId() {
        return id;
    }
    public void setId(float id) {
        this.id = id;
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
}
