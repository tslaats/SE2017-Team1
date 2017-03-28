package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  This is the petri graph base data structure. It extends from the super class
 *  Graph. It holds all of the information that a petri graph needs, and all the
 *  constructors that the user interface group needs to create, and populate the
 *  structure. This  includes transitions, places and indicators for start & end
 */
public class PetriNet extends JPanel {
	
    private PetriPlace start = null;
    private PetriPlace end = null;
    private ArrayList<PetriTransition> transitions = new ArrayList<PetriTransition>();
    private ArrayList<PetriPlace> places = new ArrayList<PetriPlace>();
    
    /**
     *  This is an empty constructor, that is used to instantiate a new instance
     *  of the Graph class. It takes no parameters and it might appear like
     *  it isn't doing anything. However, the variables are instantiated using a
     *  lazy-instantiation, so they do not need to be created in the constructor
     *  at all. But the constructor still has to be defined, as we might need to
     *  implement more constructors or add additional auto-generated information
     */
    public PetriNet () {
        
    }
    
    /**
     *  This tries to retrieve/set a place, and if it has been assigned it will then
     *  return it. However in the case that it hasn't been set and someone tries
     *  to get it, it will throw an exception as that is an illegal graph action
     */
    public PetriPlace getStart () {
        if (start == null) {
            throw new NullPointerException();
        }
        else {
            return (start);
        }
    }

    // setStart
    public void setStart(PetriPlace inputStart) {
        if (inputStart == null) {
            throw new NullPointerException();
        }
        else {
            start = inputStart;
        };
    }
    
    /**
     *  This tries to retrieve a place, and if it has been assigned it will then
     *  return it. However in the case that it hasn't been set and someone tries
     *  to get it, it will throw an exception as that is an illegal graph action
     */
    public PetriPlace getEnd () {
        if (end == null) {
            throw new NullPointerException();
        }
        else {
            return (end);
        }
    }

    // setEnd
    public void setEnd(PetriPlace inputEnd) {
        if (inputEnd == null) {
            throw new NullPointerException();
        }
        else {
            end = inputEnd;
        }
    }
    
    public void addSinglePlace(PetriPlace place) {
    	places.add(place);
    }
    
    public void addPlaces(ArrayList<PetriPlace> places) {
    	this.places.addAll(places);
    }
    
    public void addSingleTransition(PetriTransition transition) {
    	transitions.add(transition);
    }
    
    public void addTransitions(ArrayList<PetriTransition> transitions) {
    	this.transitions.addAll(transitions);
    }
    
    public ArrayList<PetriPlace> getPlaces() {
    	return places;
    }
    
    public ArrayList<PetriTransition> getTransitions() {
    	return transitions;
    }
    
    /**
     *  Since a start can be null, this getter allows a caller to check if there
     *  is actually anything assigned to the variable, or if it is actually null
     */
    public boolean hasStart () {
        return (start != null);
    }
    
    /**
     *  Since an end can be null, this getter allows a caller, to check if there
     *  is actually anything assigned to the variable, or if it is actually null
     */
    public boolean hasEnd () {
        return (end != null);
    }
    
    /**
     *  This is a toString override. It creates a pretty print format of all the
     *  content. It even handles the cases where the start and end points appear
     *  as null values. It creates a nice multi-line formatted structure, whitch
     *  allows the user to visually inspect the data, and see how it appears, as
     *  a list. It does not format to any graph like image though. This is meant
     *  for debugging purposes, and for these reasons stringbuilder was not used
     *  even though it would be obvious. The format looks weird, but look at the
     *  course page, for a post about the format and how it looks after printing
     */
    public String toString () {
        String result = "Graph (start: " + (start == null ? "none" : "assigned") +
                        ", end: " + (end == null ? "end" : "assigned") + ")";
        
        result = result + "\n- Transitions:";
        
        for (PetriTransition t : transitions) {
            result = result + "\n    " + t;
        }
        
        result = result + "\n- Places:";
        
        for (PetriPlace p : places) {
            result = result + "\n    " + p;
        }
        
        return (result);
    }


    private void genSingleConnection(PetriTransition t, ArrayList<Connection> connections){
        ArrayList<PetriPlace> incoming = t.getIncoming();
        ArrayList<PetriPlace> outgoing = t.getOutgoing();

        for (PetriPlace place : incoming) {
            Connection conn = new Connection(place, t, "to_transition");
            connections.add(conn);
        }
        for (PetriPlace place : outgoing) {
            Connection conn = new Connection(place, t, "to_place");
            connections.add(conn);
        }
    }

    private ArrayList<Connection> generateAllConnections(){
    	ArrayList<Connection> connections = new ArrayList<Connection>();

        HashMap<Integer, Integer> usedId = new HashMap<Integer, Integer>(places.size() + transitions.size());

        for (PetriTransition t : transitions) {
            if (usedId.containsKey(t.getId())){
                ;
            }
            else {
                genSingleConnection(t, connections);
                usedId.put(t.getId(), t.getId());
            }
        }
        return connections;
    }

    @Override
    public void paint(Graphics g){
    	
        g.setColor(new Color(71, 71, 71));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        Graphics2D graphics = (Graphics2D) g;
        for (int i = 0, m = getWidth() / 20; i < m; i++) {
            graphics.setColor(i % 5 == 0 ? new Color(94, 94, 94) : new Color(80, 80, 80));
            Line2D l = new Line2D.Float(i * 20, 0, i * 20, getWidth());
            graphics.draw(l);
        }
        for (int i = 0, m = getHeight() / 20; i < m; i++) {
            graphics.setColor(i % 5 == 0 ? new Color(94, 94, 94) : new Color(80, 80, 80));
            Line2D l = new Line2D.Float(0, i * 20, getWidth(), i * 20);
            graphics.draw(l);
        }
    	
    	ArrayList<Connection> connections = generateAllConnections();

        for (Connection c : connections) {
            c.paint(g);
        }
        for (PetriTransition t : transitions) {
            t.paintTransition(g);
        }
        for (PetriPlace p : places) {
            p.paintPlace(g);
        }
    }
}
