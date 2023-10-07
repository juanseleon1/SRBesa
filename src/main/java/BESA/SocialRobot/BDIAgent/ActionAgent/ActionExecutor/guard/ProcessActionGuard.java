package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.guard;

import java.util.List;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ModulatedActionRequestData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask.TaskRequestType;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import BESA.SocialRobot.agentUtils.ServiceUtils;

public class ProcessActionGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ReportBESA.debug("ProcessActionGuard");
        ActionAgentState state = (ActionAgentState) this.agent.getState();
        DataBESA besa = event.getData();
        if (besa instanceof ModulatedActionRequestData) {
            ModulatedActionRequestData infoRecibida = (ModulatedActionRequestData) event.getData();
            List<ServiceDataRequest> primitives = infoRecibida.getServiceDataRequests();
            ReportBESA.debug("Adding task " + infoRecibida.getTaskName());
            if (!state.getActionExecutor().isActionPresent(infoRecibida.getActionId())) {
                state.getActionExecutor().addTaskForAction(infoRecibida.getTaskName(), infoRecibida.getActionId());
                ReportBESA.debug("Sending primitives..");
                primitives.forEach((primitive) -> {
                    ReportBESA.debug("Sending.. " + primitive);
                    ServiceUtils.requestService(primitive);
                    state.getActionExecutor().addPrimitiveToAction(infoRecibida.getActionId(), primitive);
                });
            }
        } else if (besa instanceof ActionRequestData) {
            ActionRequestData info = (ActionRequestData) event.getData();
            if (info.getActionName().equals(TaskRequestType.CANCEL.toString())
                    || info.getActionName().equals(TaskRequestType.INTERRUPT.toString())) {
                List<String> actions = state.getActionExecutor().getActionsPerTask(info.getTaskName());
                actions.forEach((action) -> {
                    state.getActionExecutor().getRegisteredPrimitivesPerAction(action).forEach((primitive) -> {
                        ServiceUtils.requestService(ServiceDataRequest.buildCancelRequest(primitive));
                    });
                });
                state.getActionExecutor().removeTaskData(info.getTaskName());
            }
        }
    }

}
