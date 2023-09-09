package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.guard;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.Agent.AgentBDI;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.SRAutonomyManager;
import rational.guards.InformationFlowGuard;

public class UpdatePermissionRequest extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {

        try {
            AgentBDI agentBDI = (AgentBDI) this.agent;
            StateBDI stateBDI = (StateBDI) agentBDI.getState();
            RequestUpdateData data = (RequestUpdateData) event.getData();
            SRAutonomyManager autonomyManager = (SRAutonomyManager) stateBDI.getMachineBDIParams().getAutonomyManager();
            autonomyManager.getRequests().approveRequest(data.getRequestName());
            EventBESA eventBesa = new EventBESA(InformationFlowGuard.class.getName(), data);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = agentBDI.getAdmLocal().getHandlerByAlias(agentBDI.getAlias());
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

    }

}
