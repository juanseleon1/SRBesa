package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import java.util.List;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;

public class ProcessActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ActionAgentState state = (ActionAgentState) this.agent.getState();
        ActionRequestData infoRecibida = (ActionRequestData) event.getData();
        List<ServiceDataRequest> primitives = state.getActionExecutor().getActionPrimitives(infoRecibida);
        if(!state.getActionExecutor().isActionPresent(infoRecibida.getActionName())){
            state.getActionExecutor().addTaskForAction(infoRecibida.getTaskName(), infoRecibida.getActionName());
        }
        primitives.forEach((primitive) -> {
            ServiceUtils.requestService(primitive);
            state.getActionExecutor().addPrimitiveToAction(infoRecibida.getActionName(), primitive.getId());
        });
        // TODO: If expropiation or cancel request is sent, check task action and
        // interrupt related service provider actions.
    }

}
