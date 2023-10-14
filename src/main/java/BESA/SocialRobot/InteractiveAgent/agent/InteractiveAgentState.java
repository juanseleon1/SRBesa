package BESA.SocialRobot.InteractiveAgent.agent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.ExplainabilityAgent.model.EventRecord;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventBundle;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;
import BESA.SocialRobot.InteractiveAgent.manager.PromptBuilder;
import BESA.SocialRobot.ServiceProvider.agent.ServiceRequestManager;


public class InteractiveAgentState extends StateBESA {
    private Map<String, ConversationManager> conversations;
    private InterfaceInterpreter interpreter;
    private PromptBuilder promptBuilder;
    private ServiceRequestManager<String> manager;
    private ConversationManagerBuilder builder;
    private EventRecord latestInnerStateRecord;
    private EventRecord latestUserStateRecord;
    private EventRecord latestDecisionRecord;

    public InteractiveAgentState(PromptBuilder promptBuilder, InterfaceInterpreter interpreter,
            ConversationManagerBuilder builder) {
        this.conversations = new ConcurrentHashMap<>();
        this.promptBuilder = promptBuilder;
        this.interpreter = interpreter;
        this.builder = builder;
        manager = new ServiceRequestManager<>();
    }

    public Map<String, ConversationManager> getConversations() {
        return conversations;
    }

    public ConversationEventBundle processConversationEvent(InteractionEventData data) {
        //ReportBESA.debug("Processing voice event" + data);
        String id = data.getUserId();
        if (!conversations.containsKey(id)) {
            conversations.put(id, builder.buildConversationManager());
        }
        return conversations.get(id).processConversationEvent(promptBuilder, manager, data);
    }

    public EmotionalData processInterfaceInteraction(InteractionEventData data) {
        return interpreter.processInterfaceInteraction(data);
    }

    public ServiceRequestManager<String> getServiceRequestManager() {
        return manager;
    }

    public boolean hasRequestPending(String id) {
        return manager.hasRequestPending(id);
    }

    public void addRequest(String id) {
        manager.addRequest(id);
    }

    public void requestCompleted(String id) {
        manager.requestCompleted(id);
    }

    public void sendEventToAgent(DataBESA data, Class<?> guard, String alias) {
        try {
            EventBESA eventBesa = new EventBESA(guard.getName(),
                    data);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(alias);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    public EventRecord getLatestInnerStateRecord() {
        return latestInnerStateRecord;
    }

    public void setLatestInnerStateRecord(EventRecord latestInnerStateRecord) {
        this.latestInnerStateRecord = latestInnerStateRecord;
    }

    public EventRecord getLatestUserStateRecord() {
        return latestUserStateRecord;
    }

    public void setLatestUserStateRecord(EventRecord latestUserStateRecord) {
        this.latestUserStateRecord = latestUserStateRecord;
    }

    public EventRecord getLatestDecisionRecord() {
        return latestDecisionRecord;
    }

    public void setLatestDecisionRecord(EventRecord latestDecisionRecord) {
        this.latestDecisionRecord = latestDecisionRecord;
    }

}
