package petriNet.visualization;
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
public class Transition {
    private int id = -1;
    private Point position = null;
    private String name = null;
    private ArrayList<Place> incoming = new ArrayList<Place>();
    private ArrayList<Place> outgoing = new ArrayList<Place>();
    
    /**
     *  This is a constructor, that creates a new instance of the transition and
     *  populates all of the variables, such as the top left point of the object
     *  and the given name of the transition, and every of the connecting places
     */
    public Transition (int id, Point position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
    }
    
    public int getId() {
    	return id;
    }
    
    public Point getPosition() {
    	return position;
    }
    
    public String getName() {
    	return name;
    }
    
    public ArrayList<Place> getIncoming() {
    	return incoming;
    }
    
    public ArrayList<Place> getOutgoing() {
    	return outgoing;
    }
    
    public void setPosition(Point position) {
    	this.position = position;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void removeIncoming(ArrayList<Place> toBeRemoved) {
    	incoming.removeAll(toBeRemoved);
    }
    
    public void removeOutgoing(ArrayList<Place> toBeRemoved) {
    	outgoing.removeAll(toBeRemoved);
    }
    
    public void addIncoming(ArrayList<Place> toBeAdded) {
    	incoming.addAll(toBeAdded);
    }
    
    public void addOutgoing(ArrayList<Place> toBeAdded) {
    	outgoing.addAll(toBeAdded);
    }
    
    public void setIncoming(ArrayList<Place> incoming) {
    	this.incoming = incoming;
    }
    
    public void setOutgoing(ArrayList<Place> outgoing) {
    	this.outgoing = outgoing;
    }
    
    /**
     *  This is a debugging method, for printing out a textual representation of
     *  the node. It actually doesn't print, it's just a toString, sorry, my bad
     *  but yeah, so I wonder, does anyone even reads these comments I guess not
     */
    public String toString () {
        return ("Transition (Name: " + name + ", Id: " + id + ", IncomingSize: " +
                incoming.size() + ", OutgoingSize: " + outgoing.size() +
                ", Position: " + position.x + "," + position.y + ")");
    }
}
