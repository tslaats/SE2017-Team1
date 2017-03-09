package petriNet.semantics;

import petriNet.semantics.common.interfaces.CrGraph;

/**
 * Created by Mihai on 3/9/2017.
 */
public class Transition extends PetriObject {
    /**
     * Transition name
     */
    private final String name;

    /**
     * CrGraph in this Transition
     */
    private final CrGraph crGraph;

    /**
     * Constructor
     *
     * @param name
     * @param crGraph
     */
    public Transition(String name, CrGraph crGraph) {
        this.name = name;
        this.crGraph = crGraph;
    }

    /**
     * This Transition name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * This Transition's crgraph
     *
     * @return object
     */
    public CrGraph getCrGraph() {
        return crGraph;
    }
}
