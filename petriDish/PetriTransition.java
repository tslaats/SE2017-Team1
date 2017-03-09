
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import java.util.ArrayList;
import java.awt.Point;

/**
 *  This is the transition class. It holds an instance of a transition node, for
 *  a petri graph. The node contains a list of incoming- and a list of outgoing-
 *  edges (arcs), as well as a string name and the mandatory position coordinate
 */
public class PetriTransition
{
    public int                          id              = -1;
    public Point                        position        = null;
    public String                       name            = null;
    public ArrayList<PetriPlace>        incoming        = new ArrayList<PetriPlace>();
    public ArrayList<PetriPlace>        outgoing        = new ArrayList<PetriPlace>();
    
    /**
     *  This is a constructor, that creates a new instance of the transition and
     *  populates all of the variables, such as the top left point of the object
     *  and the given name of the transition, and every of the connecting places
     */
    public PetriTransition (int id, Point position, String name)
    {
        this.id         = id;
        this.position   = position;
        this.name       = name;
    }
    
    /**
     *  This is a debugging method, for printing out a textual representation of
     *  the node. It actually doesn't print, it's just a toString, sorry, my bad
     *  but yeah, so I wonder, does anyone even reads these comments I guess not
     */
    public String toString ()
    {
        return ("Transition (Name: " + name + ", Id: " + id + ", IncomingSize: " + incoming.size() + ", OutgoingSize: " + outgoing.size() + ", Position: " + position.x + "," + position.y + ")");
    }
}
