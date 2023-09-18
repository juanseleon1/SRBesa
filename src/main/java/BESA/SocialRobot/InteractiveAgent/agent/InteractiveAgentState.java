package BESA.SocialRobot.InteractiveAgent.agent;

import java.util.HashMap;
import java.util.Map;

import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventBundle;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;
import BESA.SocialRobot.InteractiveAgent.manager.PromptBuilder;
import BESA.SocialRobot.ServiceProvider.agent.ServiceRequestManager;

/**
 *
 * @author juans
 */
public class InteractiveAgentState<T extends ConversationManager, G extends InterfaceInterpreter> extends StateBESA {
    private Map<Float, T> conversations;
    private InterfaceInterpreter interpreter;
    private PromptBuilder promptBuilder;
    private ServiceRequestManager<String> manager;

    public InteractiveAgentState(PromptBuilder promptBuilder, InterfaceInterpreter interpreter) {
        this.conversations = new HashMap<>();
        this.promptBuilder = promptBuilder;
        this.interpreter = interpreter;
        manager = new ServiceRequestManager<>();
    }

    public Map<Float, T> getConversations() {
        return conversations;
    }

    public ConversationEventBundle processConversationEvent(InteractionEventData data) {
        float id = (float) data.getData().get("id");
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
}
