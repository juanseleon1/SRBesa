package BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel;

import rational.data.InfoData;
import rational.mapping.Believes;

public class WorldModel implements Believes {

    private boolean accidentOcurred;

    public WorldModel() {
        accidentOcurred = false;
    }

    @Override
    public boolean update(InfoData data) {
        boolean update = false;
        if(data instanceof AccidentData){
            AccidentData accidentData = (AccidentData) data;
            accidentOcurred = accidentData.isHasAccident();
            update = true;
        }
        return update;
    }

    @Override
    public WorldModel clone() throws CloneNotSupportedException {
        WorldModel clone = new WorldModel();
        return clone;
    }

    public boolean isAccidentOcurred() {
        return accidentOcurred;
    }

    public void setAccidentOcurred(boolean accidentOcurred) {
        this.accidentOcurred = accidentOcurred;
    }

    
    
}
