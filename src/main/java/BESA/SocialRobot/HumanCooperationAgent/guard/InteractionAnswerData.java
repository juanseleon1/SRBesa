package BESA.SocialRobot.HumanCooperationAgent.guard;



import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class InteractionAnswerData extends InfoData {
    private boolean approved;
    private String id;

    public InteractionAnswerData(boolean approved, String id){
        super(null);
        this.approved = approved;
        this.id = id;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
