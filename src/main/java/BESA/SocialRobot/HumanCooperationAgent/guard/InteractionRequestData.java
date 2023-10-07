package BESA.SocialRobot.HumanCooperationAgent.guard;

import java.util.List;

import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;

import rational.data.InfoData;


public class InteractionRequestData extends InfoData{
    List<Request> requests;

    public InteractionRequestData(List<Request> requests){
        super(null);
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

}
