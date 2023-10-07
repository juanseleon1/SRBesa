package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Kernel.Social.ServiceProvider.agent.SPServiceDataRequest;
import BESA.Kernel.Social.ServiceProvider.agent.StateServiceProvider;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.ServiceProvider.agent.ServiceProviderState;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import rational.services.AsynchronousService;

public abstract class SRService<T extends SRServiceConfiguration> extends AsynchronousService {

    private T config;
    private SRAdapterReceiver receiver;

    public SRService(ServiceNames name, SRAdapter adapter, SRAdapterReceiver receiver, T config) {
        super(name.name(), adapter);
        this.config = config;
        this.receiver = receiver;
        adapter.startAdapter();
        receiver.startReceiver(name);
    }

    @Override
    public void executeAsyncService(SPServiceDataRequest dataRequest, StateServiceProvider state) {
        ServiceDataRequest request = (ServiceDataRequest) dataRequest;
        ServiceProviderState spState = (ServiceProviderState) state;
        spState.addRequest(request.getId());
        ReportBESA.debug("Sending request to robot with id " + request.getId());
        SRAdapter adapter = (SRAdapter) this.getAdapter();
        RobotData data = null;
        if (request.isCancelAction()) {
            data = config.convertCancelActionToRobotData(request);
        } else {
            data = config.convertServiceDataToRobotData(request);
        }
        if (data != null) {
            adapter.sendRequest(data);
        }
    }

    public T getConfig() {
        return config;
    }

    public void setConfig(T config) {
        this.config = config;
    }

    public SRAdapterReceiver getReceiver() {
        return receiver;
    }

    public void setReceiver(SRAdapterReceiver receiver) {
        this.receiver = receiver;
    }
}
