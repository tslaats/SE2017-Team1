package petriNet.visualization.petriNet;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
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
    
    public void setPosition(Point position) throws petriNetException {
    	if (position == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	
    	this.position = position;
    }
    
    public void setIncoming(Transition incoming) throws petriNetException {
    	this.incoming = incoming;
    }
    
    public void setOutgoing(Transition outgoing) throws petriNetException {    	
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