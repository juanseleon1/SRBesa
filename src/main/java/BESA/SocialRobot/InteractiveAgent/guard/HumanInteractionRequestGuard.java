package BESA.SocialRobot.InteractiveAgent.guard;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;
import BESA.Kernel.Agent.GuardBESA;

public class HumanInteractionRequestGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        InteractiveAgentState<?, ?> state = (InteractiveAgentState<?, ?>) this.getAgent().getState();
        ServiceDataRequest data = (ServiceDataRequest) ebesa.getData();
        data.setFromInteractionAgent(true);
        if (data.getParams().containsKey("origin")) {
            String origin = (String) data.getParams().get("origin");
            state.addRequest(origin);
        }
        ServiceUtils.requestService(data);
    }
}
