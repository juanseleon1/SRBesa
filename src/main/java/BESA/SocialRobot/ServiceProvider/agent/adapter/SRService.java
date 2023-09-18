package BESA.SocialRobot.ServiceProvider.agent.adapter;

import BESA.Adapter.AdapterBESA;
import BESA.Kernel.Social.ServiceProvider.agent.SPServiceDataRequest;
import BESA.Kernel.Social.ServiceProvider.agent.StateServiceProvider;
import BESA.SocialRobot.ServiceProvider.agent.ServiceProviderState;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import rational.services.AsynchronousService;

public abstract class SRService<T extends SRServiceConfiguration> extends AsynchronousService {

    private T config;

    public SRService(String name, AdapterBESA adapter, T config) {
        super(name, adapter);
        this.config = config;
    }

    @Override
    public void executeAsyncService(SPServiceDataRequest dataRequest, StateServiceProvider state) {
        ServiceDataRequest request = (ServiceDataRequest) dataRequest;
        ServiceProviderState spState = (ServiceProviderState)state;
        spState.addRequest(request.getId());
        RobotData data = config.convertServiceDataToRobotData(request);
        SRAdapter adapter = (SRAdapter) this.getAdapter();
        adapter.sendRequest(data);
    }

    public T getConfig() {
        return config;
    }

    public void setConfig(T config) {
        this.config = config;
    }

}
