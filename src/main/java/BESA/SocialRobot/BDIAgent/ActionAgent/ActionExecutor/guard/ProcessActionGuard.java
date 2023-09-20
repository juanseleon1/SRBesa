package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import java.util.List;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask.TaskRequestType;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;

public class ProcessActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ActionAgentState state = (ActionAgentState) this.agent.getState();
        ActionRequestData infoRecibida = (ActionRequestData) event.getData();
        List<ServiceDataRequest> primitives = state.getActionExecutor().getActionPrimitives(infoRecibida);
        if(infoRecibida.getActionName().equals(TaskRequestType.CANCEL.toString()) || infoRecibida.getActionName().equals(TaskRequestType.INTERRUPT.toString())){
            List<String> actions = state.getActionExecutor().getActionsPerTask(infoRecibida.getTaskName());
            actions.forEach((action) -> {
                state.getActionExecutor().getRegisteredPrimitivesPerAction(action).forEach((primitive) -> {
                    ServiceUtils.requestService(ServiceDataRequest.buildCancelRequest(primitive));
                });
            });
            state.getActionExecutor().removeTaskData(infoRecibida.getTaskName());
        } else{
            if(!state.getActionExecutor().isActionPresent(infoRecibida.getActionName())){
                state.getActionExecutor().addTaskForAction(infoRecibida.getTaskName(), infoRecibida.getActionName());
                primitives.forEach((primitive) -> {
                    ServiceUtils.requestService(primitive);
                    state.getActionExecutor().addPrimitiveToAction(infoRecibida.getActionName(), primitive);
                });
            }
        }
    }

}
