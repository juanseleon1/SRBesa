package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import rational.mapping.Believes;

/**
 *
 * @author juans
 */
public interface ResPwAStrategy{
    
    public abstract void execStrategy(Believes b);
    public abstract boolean isFinished(Believes b);
    
}
