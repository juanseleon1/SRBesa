/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import rational.data.InfoData;
import rational.mapping.Believes;

public class InternalState implements Believes {

    public InternalState() {
        super();
    }

    @Override
    public boolean update(InfoData si) {

        return true;
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        super.clone();
        return this;
    }
}