package petriNet.visualization.petriNet;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil Bak, Frederik Henriksen, Mads, Susanne Truong, Philip Falck
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import petriNet.visualization.utils.petriNetConstants;
import petriNet.visualization.utils.petriNetException;

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
     * @param id - int
     * @param position - Point, is validated, so the transition does not go to a negative coordinate
     * @param token - boolean
     * @param incoming - Transition
     * @param outgoing - Transition
     * @throws petriNetException 
     */
    public Place (int id, Point position, boolean token, Transition incoming, Transition outgoing) throws petriNetException {
    	if (position.getX() < 15 || position.getY() < 15) {
    		throw new petriNetException(petriNetConstants.INVALID_POSITION);
        }
    	if (id < 0) {
            throw new petriNetException(petriNetConstants.INVALID_ID);
        }
    	if (incoming == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (outgoing == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
        this.id         = id;
        this.position   = position;
        this.token      = token;
        this.incoming   = incoming;
        this.outgoing   = outgoing;
    }
    
    /**
     * Gets the id
     * @return id - an int
     */
    public int getId() {
    	return id;
    }
    
    /**
     * Gets the position
     * @return position - a Point
     */
    public Point getPosition() {
    	return position;
    }
    
    /**
     * Gets the incoming transition
     * @return incoming - A Transition
     */
    public Transition getIncoming() {
    	return incoming;
    }
    
    /**
     * Gets the outgoing transition
     * @return outgoing - A Transition
     */
    public Transition getOutgoing() {
    	return outgoing;
    }
    
    /**
     * Returns whether it has a token or not
     * @return token - a boolean
     */
    public boolean getToken() {
    	return token;
    }
    
    /**
     * Set position
     * @param position - new position
     * @throws petriNetException
     */
    public void setPosition(Point position) throws petriNetException {
    	if (position == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (position.getX() < 15 || position.getY() < 15) {
    		throw new petriNetException(petriNetConstants.INVALID_POSITION);
        }
    	
    	this.position = position;
    }
    
    /**
     * Set the incoming transition
     * @param incoming - a Transition
     * @throws petriNetException
     */
    public void setIncoming(Transition incoming) throws petriNetException {
    	this.incoming = incoming;
    }
    
    /**
     * Set the outgoing transition
     * @param outgoing - a Transition
     * @throws petriNetException
     */
    public void setOutgoing(Transition outgoing) throws petriNetException {    	
    	this.outgoing = outgoing;
    }
    
    /**
     * Set the token
     * @param token - a boolean
     * @throws petriNetException
     */
    public void setToken(boolean token) {
    	this.token = token;
    }
    
    /**
     * Toggle the token
     * @throws petriNetException
     */
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

    /**
     * Paints the Place
     * @param g - graphic object to contain the Place
     */
    public void paintPlace(Graphics g){
        int diameter = 30;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        Ellipse2D.Double circle = new Ellipse2D.Double((position.x - (diameter / 2)), (position.y - (diameter / 2)),
                diameter, diameter);
        g2d.fill(circle);

        g2d.setColor(Color.GREEN);
        g2d.fill(circle);
        if (token){
            g2d.setColor(Color.DARK_GRAY);
            Ellipse2D.Double t = new Ellipse2D.Double((position.x - (diameter / 4)),
                    (position.y - (diameter / 4)),
                    (diameter / 2), (diameter / 2));
            g2d.fill(t);
        }
    }
}