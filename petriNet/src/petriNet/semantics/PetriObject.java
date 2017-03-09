package petriNet.semantics;

import petriNet.semantics.common.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Some methods return the same instance to enable "chaining"
 *
 * Created by Mihai on 3/9/2017.
 */
public class PetriObject {

    /**
     * Unique ID
     */
    private final int id;

    /**
     * Obbject position instance
     */
    private Position position;

    /**
     * List of incoming objects
     */
    private final List<PetriObject> incoming = new ArrayList<>();

    /**
     * List of outgoing objects
     */
    private final List<PetriObject> outgoing = new ArrayList<>();

    PetriObject() {
        this.id = Util.uniqueID();
    }

    /**
     * Constructor
     *
     * @param id
     * @param position
     */
    public PetriObject(int id, Position position) {
        this.id = id;
        this.position = position;
    }

    /**
     * Incoming obhects
     * @return PetriObject
     */
    public List<PetriObject> getIncoming() {
        return incoming;
    }

    /**
     * Outgoing objects
     * @return PetriObject
     */
    public List<PetriObject> getOutgoing() {
        return outgoing;
    }

    /**
     * Add incoming object
     *
     * @param petriObject
     * @return PetriObject
     */
    public PetriObject addIncoming(PetriObject petriObject)
    {
        incoming.add(petriObject);
        return this;
    }

    /**
     * Add outgoing object
     *
     * @param petriObject
     * @return PetriObject
     */
    public PetriObject addOutgoing(PetriObject petriObject)
    {
        outgoing.add(petriObject);
        return this;
    }

    /**
     * Change Position
     *
     * @param newPosition
     * @return PetriObject
     */
    public PetriObject setPosition(Position newPosition)
    {
        position = newPosition;
        return this;
    }
}
