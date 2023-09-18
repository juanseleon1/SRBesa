package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;


import rational.mapping.Believes;

/**
 *
 * @author juans
 */
public interface SRStrategy{
    
    public abstract void executeStrategy(Believes b);
    public abstract boolean isFinished(Believes b);
    
}
