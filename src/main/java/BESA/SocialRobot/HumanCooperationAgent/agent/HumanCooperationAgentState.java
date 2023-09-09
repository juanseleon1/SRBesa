package BESA.SocialRobot.HumanCooperationAgent.agent;



import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BESA.Kernel.Agent.StateBESA;
import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;

/**
 *
 * @author juans
 */
public class HumanCooperationAgentState extends StateBESA{
    private Map<Float, ConversationManager> conversations;
}
