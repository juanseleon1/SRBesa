package BESA.SocialRobot.InteractiveAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class InteractionRequestGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        InteractiveAgentState<?, ?> state = (InteractiveAgentState<?, ?>) this.getAgent().getState();
        ServiceDataRequest data = (ServiceDataRequest) ebesa.getData();
        if (data.getParams().containsKey("origin")) {
            String origin = (String) data.getParams().get("origin");
            state.addRequest(origin);
        } else{
            //TODO: add text to context. Here goes personalization and emotion to talk. 
        }
        //TODO: Send Service Request to the service provider
    }
}
