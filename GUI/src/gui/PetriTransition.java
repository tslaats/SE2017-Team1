package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil S. Bak, Philip Falck
 *  @contact >> 
 *  @version >> 1.2.0
 *  @updated >> 21/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.util.ArrayList;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 * This is the transition class. It holds an instance of a transition node, for
 * a petri graph. The node contains a list of incoming- and a list of outgoing-
 * edges (arcs), as well as a string name and the mandatory position coordinate
 */
public class PetriTransition
{
    public int                          id                  = -1;
    public Point                        position            = null;
    public String                       name                = null;
    public ArrayList<PetriPlace>        incoming            = new ArrayList<PetriPlace>();
    public ArrayList<PetriPlace>        outgoing            = new ArrayList<PetriPlace>();
    public int                          subgraphID          = -1;
    /**
     * This is a constructor, that creates a new instance of the transition and
     * populates all of the variables, such as the top left point of the object
     * and the given name of the transition, and every of the connecting places
     */
    public PetriTransition(int id, Point position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
    }

    /**
     * This is a debugging method, for printing out a textual representation of
     * the node. It actually doesn't print, it's just a toString, sorry, my bad
     * but yeah, so I wonder, does anyone even reads these comments I guess not
     */
    public String toString() {
        return ("Transition (Name: " + name + ", Id: " + id
                + ", IncomingSize: " + incoming.size() + ", OutgoingSize: "
                + outgoing.size() + ", Position: " + position.x + ","
                + position.y + ")");
    }
    
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
    
    /**
     * Returns boolean stating whether or not the event/activity has a subgraph
     */
    public boolean hasSubgraph()
    {
        return (subgraphID != -1);
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
    
    public ArrayList<PetriPlace> getIncoming() {
    	return incoming;
    }
    
    public ArrayList<PetriPlace> getOutgoing() {
    	return outgoing;
    }
    
    public void setPosition(Point position) {
    	this.position = position;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void removeIncoming(ArrayList<PetriPlace> toBeRemoved) {
    	incoming.removeAll(toBeRemoved);
    }
    
    public void removeOutgoing(ArrayList<PetriPlace> toBeRemoved) {
    	outgoing.removeAll(toBeRemoved);
    }
    
    public void addIncoming(ArrayList<PetriPlace> toBeAdded) {
    	incoming.addAll(toBeAdded);
    }
    
    public void addOutgoing(ArrayList<PetriPlace> toBeAdded) {
    	outgoing.addAll(toBeAdded);
    }
    
    public void setIncoming(ArrayList<PetriPlace> incoming) {
    	this.incoming = incoming;
    }
    
    public void setOutgoing(ArrayList<PetriPlace> outgoing) {
    	this.outgoing = outgoing;
    }
}
