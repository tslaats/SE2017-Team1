package petriNet.src.petriNet.visualization.petriNet;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
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
public class Place {
    private int id = -1;
    private Point position = null;
    private boolean token = false;
    private Transition incoming = null;
    private Transition outgoing = null;
    
    /**
     *  This is a constructor that creates a new instance of the place class and
     *  populates all of the variables, such as the top left point of the object
     *  and if this place has a token initially, and all of the edge transitions
     */
    public Place (int id, Point position, boolean token, Transition incoming, Transition outgoing) {
        this.id         = id;
        this.position   = position;
        this.token      = token;
        this.incoming   = incoming;
        this.outgoing   = outgoing;
    }
    
    public int getId() {
    	return id;
    }
    
    public Point getPosition() {
    	return position;
    }
    
    public Transition getIncoming() {
    	return incoming;
    }
    
    public Transition getOutgoing() {
    	return outgoing;
    }
    
    public boolean getToken() {
    	return token;
    }
    
    public void setPosition(Point position) {
    	this.position = position;
    }
    
    public void setIncoming(Transition incoming) {
    	this.incoming = incoming;
    }
    
    public void setOutgoing(Transition outgoing) {
    	this.outgoing = outgoing;
    }
    
    public void setToken(boolean token) {
    	this.token = token;
    }
    
    public void toggleToken() {
    	token = !token;
    }
    
    /**
     *  This is a debugging method, for returning out a textual representation of
     *  the node, meant for printing.
     */
    public String toString () {
        return ("Place (Token: " + token + ", Id: " + id + ", Incoming: " +
                (incoming == null ? "none" : "assigned") + ", Outgoing: " +
                (outgoing == null ? "none" : "assigned") + ", Position: " +
                position.x + "," + position.y + ")");
    }
}