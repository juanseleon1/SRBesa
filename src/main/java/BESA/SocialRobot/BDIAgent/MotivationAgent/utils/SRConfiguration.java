package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgent;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterAgent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterStrategy;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgent;
import BESA.SocialRobot.ExplainabilityAgent.agent.RecordSaver;
import BESA.SocialRobot.HumanCooperationAgent.agent.HumanCooperationAgent;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgent;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.RiskDetectionAgent.agent.RiskDetectionAgent;
import BESA.SocialRobot.RiskDetectionAgent.agent.RiskDetectionAgentState;
import BESA.SocialRobot.ServiceProvider.agent.ServiceProviderAgent;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterAgent;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterState;

public abstract class SRConfiguration {

    private MotivationAgentConfiguration config;
    private Map<String, List<SRService<?>>> sps;
    private List<ServiceProviderAgent> serviceProviders;
    private MotivationAgent motivationAgent;
    private ActionAgent actionAgent;
    private RecordSaver recordSaver;
    private EmotionalInterpreterStrategy eas;
    private InteractiveAgentState interactiveAgentState;
    private UserEmotionalInterpreterState userEmotionalInterpreterState;
    private ExplainabilityAgent explainabilityAgent;
    private EmotionalInterpreterAgent emotionalInterpreterAgent;
    private HumanCooperationAgent humanCooperationAgent;
    private InteractiveAgent interactiveAgent;
    private RiskDetectionAgent riskDetectionAgent;
    private UserEmotionalInterpreterAgent userEmotionalInterpreterAgent;
    private ActionAgentState actionAgentState;
    private RiskDetectionAgentState riskDetectionAgentState;


    public SRConfiguration() {
        sps = new ConcurrentHashMap<>();
        serviceProviders = new ArrayList<>();
    }

    public void setup() {
        try {
            AdmBESA.getInstance();
            setupServiceProviders();
            setupSupportAgents();
            setupActionAgent();
            setupLatentGoalStructureAndMasks();
            setupMotivationAgent();
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

    }

    protected abstract void setupLatentGoalStructureAndMasks();

    public void start() {
        try {
            serviceProviders.forEach(sp -> sp.start());
            actionAgent.start();
            motivationAgent.start();
            explainabilityAgent.start();
            emotionalInterpreterAgent.start();
            humanCooperationAgent.start();
            interactiveAgent.start();
            riskDetectionAgent.start();
            userEmotionalInterpreterAgent.start();
            motivationAgent.startTimers();
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    protected void setupServiceProviders() {
        sps.forEach((alias, services) -> {
            try {
                ServiceProviderAgent sp = ServiceProviderAgent.buildServiceProviderAgent(alias, services);
                serviceProviders.add(sp);
            } catch (ExceptionBESA e) {
                e.printStackTrace();
            }
        });

    }

    protected void setupSupportAgents() throws KernelAgentExceptionBESA {
         explainabilityAgent = new ExplainabilityAgent(recordSaver);
         emotionalInterpreterAgent = new EmotionalInterpreterAgent(eas);
         humanCooperationAgent = new HumanCooperationAgent();
         interactiveAgent = new InteractiveAgent(interactiveAgentState);
         riskDetectionAgent = new RiskDetectionAgent(riskDetectionAgentState);
         userEmotionalInterpreterAgent = new UserEmotionalInterpreterAgent(
                userEmotionalInterpreterState);

    }

    protected void setupActionAgent() throws KernelAgentExceptionBESA {
        actionAgent = new ActionAgent(actionAgentState);

    }

    protected void setupMotivationAgent() throws KernelAgentExceptionBESA, ExceptionBESA {
        motivationAgent = new MotivationAgent(config);
    }

    public void addServiceProviderConfig(String alias, List<SRService<?>> services) {
        sps.put(alias, services);
    }

    public MotivationAgentConfiguration getConfig() {
        return config;
    }

    public void setConfig(MotivationAgentConfiguration config) {
        this.config = config;
    }

    public Map<String, List<SRService<?>>> getSps() {
        return sps;
    }

    public void setSps(Map<String, List<SRService<?>>> sps) {
        this.sps = sps;
    }

    public List<ServiceProviderAgent> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(List<ServiceProviderAgent> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public MotivationAgent getMotivationAgent() {
        return motivationAgent;
    }

    public ActionAgent getActionAgent() {
        return actionAgent;
    }


    public RecordSaver getRecordSaver() {
        return recordSaver;
    }

    public void setRecordSaver(RecordSaver recordSaver) {
        this.recordSaver = recordSaver;
    }

    public EmotionalInterpreterStrategy getEas() {
        return eas;
    }

    public void setEas(EmotionalInterpreterStrategy eas) {
        this.eas = eas;
    }

    public InteractiveAgentState getInteractiveAgentState() {
        return interactiveAgentState;
    }

    public void setInteractiveAgentState(InteractiveAgentState interactiveAgentState) {
        this.interactiveAgentState = interactiveAgentState;
    }

    public UserEmotionalInterpreterState getUserEmotionalInterpreterState() {
        return userEmotionalInterpreterState;
    }

    public void setUserEmotionalInterpreterState(UserEmotionalInterpreterState userEmotionalInterpreterState) {
        this.userEmotionalInterpreterState = userEmotionalInterpreterState;
    }

    public ExplainabilityAgent getExplainabilityAgent() {
        return explainabilityAgent;
    }

    public void setExplainabilityAgent(ExplainabilityAgent explainabilityAgent) {
        this.explainabilityAgent = explainabilityAgent;
    }

    public EmotionalInterpreterAgent getEmotionalInterpreterAgent() {
        return emotionalInterpreterAgent;
    }

    public void setEmotionalInterpreterAgent(EmotionalInterpreterAgent emotionalInterpreterAgent) {
        this.emotionalInterpreterAgent = emotionalInterpreterAgent;
    }

    public HumanCooperationAgent getHumanCooperationAgent() {
        return humanCooperationAgent;
    }

    public void setHumanCooperationAgent(HumanCooperationAgent humanCooperationAgent) {
        this.humanCooperationAgent = humanCooperationAgent;
    }

    public InteractiveAgent getInteractiveAgent() {
        return interactiveAgent;
    }

    public void setInteractiveAgent(InteractiveAgent interactiveAgent) {
        this.interactiveAgent = interactiveAgent;
    }

    public UserEmotionalInterpreterAgent getUserEmotionalInterpreterAgent() {
        return userEmotionalInterpreterAgent;
    }

    public void setUserEmotionalInterpreterAgent(UserEmotionalInterpreterAgent userEmotionalInterpreterAgent) {
        this.userEmotionalInterpreterAgent = userEmotionalInterpreterAgent;
    }

    public ActionAgentState getActionAgentState() {
        return actionAgentState;
    }

    public void setActionAgentState(ActionAgentState actionAgentState) {
        this.actionAgentState = actionAgentState;
    }

    public void setMotivationAgent(MotivationAgent motivationAgent) {
        this.motivationAgent = motivationAgent;
    }

    public void setActionAgent(ActionAgent actionAgent) {
        this.actionAgent = actionAgent;
    }

    public RiskDetectionAgent getRiskDetectionAgent() {
        return riskDetectionAgent;
    }

    public void setRiskDetectionAgent(RiskDetectionAgent riskDetectionAgent) {
        this.riskDetectionAgent = riskDetectionAgent;
    }

    public RiskDetectionAgentState getRiskDetectionAgentState() {
        return riskDetectionAgentState;
    }

    public void setRiskDetectionAgentState(RiskDetectionAgentState riskDetectionAgentState) {
        this.riskDetectionAgentState = riskDetectionAgentState;
    }
    
}
