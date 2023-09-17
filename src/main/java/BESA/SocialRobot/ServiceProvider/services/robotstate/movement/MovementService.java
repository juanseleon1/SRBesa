package BESA.SocialRobot.ServiceProvider.services.robotstate.movement;

import BESA.Adapter.AdapterBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;

public class MovementService extends SRService<MovementServiceConfig>{

    public MovementService(String name, AdapterBESA adapter, MovementServiceConfig config) {
        super(name, adapter, config);
    }
    
}
