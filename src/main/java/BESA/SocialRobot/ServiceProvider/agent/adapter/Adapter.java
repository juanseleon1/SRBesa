package BESA.SocialRobot.ServiceProvider.agent.adapter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Adapter.AdapterBESA;

/**
 *
 * @author juans
 */
public abstract class Adapter extends AdapterBESA{
    //protected AdapterReceiver receiver;
    protected static int numPackage=0;

    protected Adapter()
    {
        //TODO: Add agent handler and event to send.
        super(null,null);
    }
    
    public synchronized static int sendNewSendable(){
        return numPackage++;
    }

    //TODO: Logic for handling events.    
}
