package BESA.SocialRobot.ExplainabilityAgent.guard;



import BESA.Kernel.Agent.Event.EventBESA;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
import BESA.Kernel.Agent.GuardBESA;

/**
 *
 * @author juans
 */
public class SaveRecordsGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        ExplainabilityAgentState state = (ExplainabilityAgentState) this.getAgent().getState();
        RecordData infoRecibida = (RecordData) ebesa.getData();
        state.addListOfRecords(infoRecibida.getRecords());
    }

}
