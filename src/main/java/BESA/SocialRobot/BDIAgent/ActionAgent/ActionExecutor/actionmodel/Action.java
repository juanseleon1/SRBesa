package BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel;

import java.util.HashSet;
import java.util.Set;

public class Action {
    String name;
    Set<Primitive> primitives;

    public Action() {
        primitives = new HashSet<>();
    }

    public Action(String name) {
        this.name = name;
        primitives = new HashSet<>();
    }

    public void addPrimitive(Primitive primitive) {
        primitives.add(primitive);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Primitive> getPrimitives() {
        return primitives;
    }

    public void setPrimitives(Set<Primitive> primitives) {
        this.primitives = primitives;
    }

    
}
