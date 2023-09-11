package BESA.SocialRobot.HumanCooperationAgent.guard;

import java.util.List;

import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;

//TODO: Check angela thesis to implement this

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import rational.data.InfoData;

/**
 *
 * @author juans
 */
public class InteractionRequestData extends InfoData{
    List<Request> requests;

    public InteractionRequestData(List<Request> requests){
        super(null);
        this.requests = requests;
    }
    
//TODO: Define Data Contents    
}
