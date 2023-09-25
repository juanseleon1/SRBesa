package BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState;

import java.util.List;

public class RobotResources {
    protected List<Resource> resources;

    public RobotResources() {
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void removeResource(Resource resource) {
        resources.remove(resource);
    }

}
