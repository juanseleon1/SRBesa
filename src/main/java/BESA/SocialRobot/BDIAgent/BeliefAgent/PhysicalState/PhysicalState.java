package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.AccidentMgmt.ErrorState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.AccidentMgmt.ExceptionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.InternalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.Resources.ComputationalResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.Resources.ExternalResourcesState;
import rational.data.InfoData;
import rational.mapping.Believes;

public class PhysicalState implements Believes {
    private ErrorState errorState = new ErrorState();
    private ExceptionState exceptionState = new ExceptionState();
    private InternalState internalState = new InternalState();
    private RobotResources robotResources = new RobotResources();
    private ComputationalResources computationalResources = new ComputationalResources();
    private ExternalResourcesState externalResourcesState = new ExternalResourcesState();

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public ErrorState getErrorState() {
        return errorState;
    }

    public void setErrorState(ErrorState errorState) {
        this.errorState = errorState;
    }

    public ExceptionState getExceptionState() {
        return exceptionState;
    }

    public void setExceptionState(ExceptionState exceptionState) {
        this.exceptionState = exceptionState;
    }

    public InternalState getInternalState() {
        return internalState;
    }

    public void setInternalState(InternalState internalState) {
        this.internalState = internalState;
    }

    public RobotResources getRobotResources() {
        return robotResources;
    }

    public void setRobotResources(RobotResources robotResources) {
        this.robotResources = robotResources;
    }

    public ComputationalResources getComputationalResources() {
        return computationalResources;
    }

    public void setComputationalResources(ComputationalResources computationalResources) {
        this.computationalResources = computationalResources;
    }

    public ExternalResourcesState getExternalResourcesState() {
        return externalResourcesState;
    }

    public void setExternalResourcesState(ExternalResourcesState externalResourcesState) {
        this.externalResourcesState = externalResourcesState;
    }


}
