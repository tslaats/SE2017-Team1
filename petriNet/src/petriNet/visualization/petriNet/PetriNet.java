/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  This is the petri graph base data structure. It extends from the super class
 *  Graph. It holds all of the information that a petri graph needs, and all the
 *  constructors that the user interface group needs to create, and populate the
 *  structure. This  includes transitions, places and indicators for start & end
 */
public class PetriNet extends JPanel {
    private Place start = null;
    private Place end = null;
    private ArrayList<Transition> transitions = new ArrayList<Transition>();
    private ArrayList<Place> places = new ArrayList<Place>();
    private ArrayList<Connection> connections = new ArrayList<Connection>();

    // Change this later, when size of objects have been decided.
    double box_width = 100; double box_height = 50;
    double circle_radius = 25;
    
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
    public Place getStart () {
        if (start == null) {
            throw new NullPointerException();
        }
        else {
            return (start);
        }
    }

    // setStart
    public void setStart(Place inputStart) {
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
    public Place getEnd () {
        if (end == null) {
            throw new NullPointerException();
        }
        else {
            return (end);
        }
    }

    // setEnd
    public void setEnd(Place inputEnd) {
        if (inputEnd == null) {
            throw new NullPointerException();
        }
        else {
            end = inputEnd;
        }
    }
    
    public void addSinglePlace(Place place) {
    	places.add(place);
    }
    
    public void addPlaces(ArrayList<Place> places) {
    	this.places.addAll(places);
    }
    
    public void addSingleTransition(Transition transition) {
    	transitions.add(transition);
    }
    
    public void addTransitions(ArrayList<Transition> transitions) {
    	this.transitions.addAll(transitions);
    }
    
    public ArrayList<Place> getPlaces() {
    	return places;
    }
    
    public ArrayList<Transition> getTransitions() {
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
        
        for (Transition t : transitions) {
            result = result + "\n    " + t;
        }
        
        result = result + "\n- Places:";
        
        for (Place p : places) {
            result = result + "\n    " + p;
        }
        
        return (result);
    }


    /* Function addArc() takes an array containing coordinates (x1,y1,x2,y2) 
     * and two strings that indicate the type of the incoming and out-coming object ("T" or "P).
     * The function then calculates the center of the objects and returns the coordinates.  
     */
    public double[] addArc(double[] coords, String from, String to) {
        double[] arc_coords = new double[4];

        // Get coordinates for incoming object (x1, y1)
        if (from.equalsIgnoreCase("T")){
            arc_coords[0] = coords[0]+50;
            arc_coords[1] = coords[1]+25;
        }
        else if (from.equalsIgnoreCase("P")){
            arc_coords[0] = coords[0] - (circle_radius/2);
            arc_coords[1] = coords[1] - (circle_radius/2);
        }
        else{
            System.out.println("ERR: type not found");
            return arc_coords;
        }

        // Get coordinates for out-coming object (x2,y2)
        if (to.equalsIgnoreCase("T")){
            arc_coords[2] = coords[2]+50;
            arc_coords[3] = coords[3]+25;
        }
        else if (to.equalsIgnoreCase("P")){
            arc_coords[2] = coords[2] - (circle_radius/2);
            arc_coords[3] = coords[3] - (circle_radius/2);
        }
        else{
            System.out.println("ERR: type not found");
            return arc_coords;
        }

        return coords;
    }

    private void genSingleConnection(Transition t){
        ArrayList<Place> incoming = t.getIncoming();
        ArrayList<Place> outgoing = t.getOutgoing();

        for (Place place : incoming) {
            Connection conn = new Connection(place, t, "to_transition");
            this.connections.add(conn);
        }
        for (Place place : outgoing) {
            Connection conn = new Connection(place, t, "to_place");
            this.connections.add(conn);
        }
    }

    private void generateAllConnections(){
        ArrayList<Connection> list = new ArrayList<>();

        HashMap usedId = new HashMap(places.size() + transitions.size());

        for (Transition t : transitions) {
            if (usedId.containsKey(t.getId())){
                ;
            }
            else {
                genSingleConnection(t);
                usedId.put(t.getId(), t.getId());
            }
        }

    }

    @Override
    public void paint(Graphics g){
        generateAllConnections();

        for (Connection c : connections) {
            c.paint(g);
        }
        for (Transition t : transitions) {
            t.paintTransition(g);
        }
        for (Place p : places) {
            p.paintPlace(g);
        }
    }
}
