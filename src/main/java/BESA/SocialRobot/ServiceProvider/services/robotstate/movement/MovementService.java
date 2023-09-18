package BESA.SocialRobot.ServiceProvider.services.robotstate.movement;

import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class MovementService extends SRService<MovementServiceConfig>{

    public MovementService(ServiceNames name, SRAdapter adapter,SRAdapterReceiver receiver, MovementServiceConfig config) {
        super(name, adapter, receiver, config);
    }
    
}
