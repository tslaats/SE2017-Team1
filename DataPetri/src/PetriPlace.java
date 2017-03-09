
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil S. Bak, Philip Falck
 *  @contact >> 
 *  @version >> 1.1.0
 *  @updated >> 09/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.util.ArrayList;
import java.awt.Point;

/**
 *  This is the class for creating a place in a petri graph. It consists of four
 *  important attributes. The coordinate, to where it should be drawn, a boolean
 *  indicating, if this has a token at the start or not, a reference to incoming
 *  and a reference to outgoing, transitions. It is currently not known if these
 *  place objects can actually have more than one outgoing / incoming connection
 */
public class PetriPlace
{
    public int                          id              = -1;
    public Point                        position        = null;
    public boolean                      token           = false;
    public PetriTransition              incoming        = null;
    public PetriTransition              outgoing        = null;
    
    /**
     *  This is a constructor that creates a new instance of the place class and
     *  populates all of the variables, such as the top left point of the object
     *  and if this place has a token initially, and all of the edge transitions
     */
    public PetriPlace (int id, Point position, boolean token, PetriTransition incoming, PetriTransition outgoing)
    {
        this.id         = id;
        this.position   = position;
        this.token      = token;
        this.incoming   = incoming;
        this.outgoing   = outgoing;
    }
    
    /**
     *  This is a debugging method, for printing out a textual representation of
     *  the node. It actually doesn't print, it's just a toString, sorry, my bad
     *  but yeah, so I wonder, does anyone even reads these comments I guess not
     */
    public String toString ()
    {
        return ("Place (Token: " + token + ", Id: " + id + ", Incoming: " + (incoming == null ? "none" : "assigned") + ", Outgoing: " + (outgoing == null ? "none" : "assigned") + ", Position: " + position.x + "," + position.y + ")");
    }
}
