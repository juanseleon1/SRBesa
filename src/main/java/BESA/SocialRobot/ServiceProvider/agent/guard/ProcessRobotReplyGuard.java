package BESA.SocialRobot.ServiceProvider.agent.guard;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.ServiceProvider.agent.ServiceProviderAgent;
import BESA.SocialRobot.ServiceProvider.agent.ServiceProviderState;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRServiceConfiguration;

public class ProcessRobotReplyGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        ServiceProviderState spState = (ServiceProviderState) this.getAgent().getState();
        RobotReplyData data = (RobotReplyData) event.getData();
        String serviceName = data.getRobotData().getService();
        SRService<?> service = (SRService<?>) spState.getDescriptor().getServiceAccessTable()
                .get(serviceName);
        SRServiceConfiguration config = service.getConfig();
        DataBESA dataBesa = config.convertRobotDataToDataBESA(data.getRobotData());
        ServiceProviderAgent agent = (ServiceProviderAgent) this.getAgent();
        if (spState.hasRequestPending(data.getId())) {
            spState.requestCompleted(data.getId());
            agent.sendActionConfirmation(data);
        }
        agent.processAsynchEvent(dataBesa, serviceName);
    }

}
