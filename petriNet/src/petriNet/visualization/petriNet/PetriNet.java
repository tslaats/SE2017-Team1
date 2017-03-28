package petriNet.visualization.petriNet;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import javax.swing.*;

import petriNet.visualization.utils.petriNetConstants;
import petriNet.visualization.utils.petriNetException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
     * @throws petriNetException 
     */
    public Place getStart () throws petriNetException {
        if (start == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
        else {
            return (start);
        }
    }

    // setStart
    public void setStart(Place inputStart) throws petriNetException {
        if (inputStart == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
        else {
            start = inputStart;
        };
    }
    
    /**
     *  This tries to retrieve a place, and if it has been assigned it will then
     *  return it. However in the case that it hasn't been set and someone tries
     *  to get it, it will throw an exception as that is an illegal graph action
     * @throws petriNetException 
     */
    public Place getEnd () throws petriNetException {
        if (end == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
        else {
            return end;
        }
    }

    // setEnd
    public void setEnd(Place inputEnd) throws petriNetException {
        if (inputEnd == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
        else {
            end = inputEnd;
        }
    }
    
    public void addSinglePlace(Place place) throws petriNetException {
    	if (place == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (this.places.contains(place)) {
			throw new petriNetException(petriNetConstants.DUPLICATED);
		}
    	ArrayList<Integer> listOfIdsToBeAdded = new ArrayList<Integer>();
    	listOfIdsToBeAdded.add(place.getId());
    	checkIds(listOfIdsToBeAdded);
    	
    	places.add(place);
    }
    
    public void addPlaces(ArrayList<Place> places) throws petriNetException {
    	if (places == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        } 
    	for (Place place : places) {
    		if (this.places.contains(place)) {
    			throw new petriNetException(petriNetConstants.DUPLICATED);
    		}
    	}
    	ArrayList<Integer> listOfIdsToBeAdded = new ArrayList<Integer>();
    	for (Place place : places) {
    		listOfIdsToBeAdded.add(place.getId());
    	}
    	checkIds(listOfIdsToBeAdded);
    	
    	this.places.addAll(places);
    }
    
    public void addSingleTransition(Transition transition) throws petriNetException {
    	if (transition == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (this.transitions.contains(transition)) {
			throw new petriNetException(petriNetConstants.DUPLICATED);
		}
    	ArrayList<Integer> listOfIdsToBeAdded = new ArrayList<Integer>();
    	listOfIdsToBeAdded.add(transition.getId());
    	checkIds(listOfIdsToBeAdded);
    	
    	transitions.add(transition);
    }
    
    public void addTransitions(ArrayList<Transition> transitions) throws petriNetException {
    	if (transitions == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	for (Transition transition : transitions) {
    		if (this.transitions.contains(transition)) {
    			throw new petriNetException(petriNetConstants.DUPLICATED);
    		}
    	}
    	ArrayList<Integer> listOfIdsToBeAdded = new ArrayList<Integer>();
    	for (Transition transition : transitions) {
    		listOfIdsToBeAdded.add(transition.getId());
    	}
    	checkIds(listOfIdsToBeAdded);
    	
    	this.transitions.addAll(transitions);
    }
    
    private void checkIds(ArrayList<Integer> listOfIdsToBeAdded) throws petriNetException {
    	ArrayList<Integer> listOfIds = new ArrayList<Integer>();
    	for (Transition transition : transitions) {
    		listOfIds.add(transition.getId());
    	}
    	for (Place place : places) {
    		listOfIds.add(place.getId());
    	}
    	if (!Collections.disjoint(listOfIdsToBeAdded, listOfIds)) {
			throw new petriNetException(petriNetConstants.DUPLICATED);
		}
    }
    
    public void removePlace(Place place) throws petriNetException {
    	if (place == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (!this.places.contains(place)) {
            throw new petriNetException(petriNetConstants.NOT_AVAILABLE);
        }
    	
    	Transition outgoing = place.getOutgoing();
    	Transition incoming = place.getIncoming();
    	incoming.removeOutgoing(place);
    	outgoing.removeIncoming(place);
    	this.places.remove(place);
    	if (place == start) {
    		start = null;
    	}
    	else if (place == end) {
    		end = null;
    	}
    }
    
    public void removeTransition(Transition transition) throws petriNetException {
    	if (transition == null) {
            throw new petriNetException(petriNetConstants.NULL_INPUT);
        }
    	if (!this.transitions.contains(transition)) {
            throw new petriNetException(petriNetConstants.NOT_AVAILABLE);
        }
    	
    	ArrayList<Place> outgoing = transition.getOutgoing();
    	ArrayList<Place> incoming = transition.getIncoming();
    	for (Place place : incoming) {
    		place.setOutgoing(null);
    	}
    	for (Place place : outgoing) {
    		place.setIncoming(null);
    	}
    	this.transitions.remove(transition);
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


    /**
     * Quality-of-life function for generating all Connections for a given Transition
     * @param t - Transition
     * @param connections - Array containing the connections
     */
    private void genSingleConnection(Transition t, ArrayList<Connection> connections){
        ArrayList<Place> incoming = t.getIncoming();
        ArrayList<Place> outgoing = t.getOutgoing();

        for (Place place : incoming) {
            Connection conn = new Connection(place, t, "to_transition");
            connections.add(conn);
        }
        for (Place place : outgoing) {
            Connection conn = new Connection(place, t, "to_place");
            connections.add(conn);
        }
    }

    /**
     * Generates all connections in the petri net
     * @return A array of connections
     */
    private ArrayList<Connection> generateAllConnections(){
    	ArrayList<Connection> connections = new ArrayList<Connection>();

        HashMap<Integer, Integer> usedId = new HashMap<Integer, Integer>(places.size() + transitions.size());

        for (Transition t : transitions) {
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

    /**
     * This is the meat and bones of the implementation. This function is both responsible for taking all
     * Places/Transitions and populate the Connections-array and draw all the figures in the petrinet
     * @param g - The graphical object used to contain the petri net
     */
    @Override
    public void paint(Graphics g){
    	ArrayList<Connection> connections = generateAllConnections();

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
