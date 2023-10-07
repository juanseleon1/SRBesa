package BESA.SocialRobot.ServiceProvider.agent.guard;

import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Log.ReportBESA;
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
        ReportBESA.debug("Processing event"+dataBesa);
        ReportBESA.debug("primitive id"+data.getPrimitiveId());
        ReportBESA.debug("has request pending"+spState);
        if (spState.hasRequestPending(data.getPrimitiveId())) {
            spState.requestCompleted(data.getPrimitiveId());
            agent.sendActionConfirmation(data);
        }
        ReportBESA.debug("Processing event"+dataBesa);
        agent.processAsynchEvent(dataBesa, serviceName);
    }

}
