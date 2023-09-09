package BESA.SocialRobot.UserEmotionalInterpreterAgent.agent;

import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;

/**
 *
 * @author juans
 */
public class UserEmotionalInterpreterState extends StateBESA{
    private Map<Float, UserEmotionalModel> userModels;
}
