package petriNet.visualization.petriNet;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import petriNet.visualization.utils.petriNetConstants;
import petriNet.visualization.utils.petriNetException;

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
     * @throws petriNetException 
     */
    public Transition (int id, Point position, String name) throws petriNetException {
    	if (position.getX() < Math.ceil(7.5*name.length())/2 || position.getY() < 20) {
    		throw new petriNetException(petriNetConstants.INVALID_POSITION);
        }
    	
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
    
    public void setPosition(Point position) throws petriNetException {
    	if (position == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (position.getX() < Math.ceil(7.5*name.length())/2 || position.getY() < 20) {
    		throw new petriNetException(petriNetConstants.INVALID_POSITION);
        }
    	
    	this.position = position;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void removeIncoming(Place toBeRemoved) throws petriNetException {
    	if (toBeRemoved == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (!this.incoming.contains(toBeRemoved)) {
            throw new petriNetException(petriNetConstants.NOT_AVAILABLE);
        }
    	
    	incoming.remove(toBeRemoved);
    }
    
    public void removeOutgoing(Place toBeRemoved) throws petriNetException {
    	if (toBeRemoved == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (!this.outgoing.contains(toBeRemoved)) {
            throw new petriNetException(petriNetConstants.NOT_AVAILABLE);
        }
    	
    	outgoing.remove(toBeRemoved);
    }
    
    public void addIncoming(ArrayList<Place> toBeAdded) throws petriNetException {
    	if (toBeAdded == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	for (Place place : toBeAdded) {
    		if (incoming.contains(place)) {
    			throw new petriNetException(petriNetConstants.DUPLICATED);
    		}
    	}
    	
    	incoming.addAll(toBeAdded);
    }
    
    public void addOutgoing(ArrayList<Place> toBeAdded) throws petriNetException {
    	if (toBeAdded == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	for (Place place : toBeAdded) {
    		if (incoming.contains(place)) {
    			throw new petriNetException(petriNetConstants.DUPLICATED);
    		}
    	}
    	
    	outgoing.addAll(toBeAdded);
    }
    
    public void setIncoming(ArrayList<Place> incoming) throws petriNetException {
    	if (incoming == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	
    	this.incoming = incoming;
    }
    
    public void setOutgoing(ArrayList<Place> outgoing) throws petriNetException {
    	if (outgoing == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
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


    /**
     * Paints the Trasition
     * @param g - graphic object to contain the Transition
     */
    public void paintTransition(Graphics g){
    	String label = name;
    	if (name.length() > 15 && !name.isEmpty()) {
    		label = name.substring(0,15);
    	}
        int width = (int) Math.ceil(7.5*name.length());
        int height = 40;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        Rectangle2D.Double rect = new Rectangle2D.Double(position.x - (width / 2), position.y - (height / 2), width, height);
        g2d.fill(rect);

        g2d.setColor(Color.BLUE);
        g2d.draw(rect);

        if ((label != null) && (!label.isEmpty())){
        	FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth( label );
            int startX = position.x - (width / 2) + ( ( width - stringWidth ) / 2 );
            int startY = position.y - (height / 2) + ( ( height + fm.getHeight() ) / 2 );
            g2d.drawString(label, startX, startY);
        }
    }
}
