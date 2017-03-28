package petriNet.visualization.Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import petriNet.visualization.petriNet.PetriNet;
import petriNet.visualization.petriNet.Place;
import petriNet.visualization.petriNet.Transition;
import petriNet.visualization.utils.petriNetException;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import java.awt.Point;


public class PetriNetTest {

	/**
     * Tests a full Graph.
     * @throws petriNetException
     *
     */
    @Test
    public void testPetriNet1() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        //Creates the places with incoming and outgoing transitions
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        //For adding incoming and outgoing places to the transitions
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        //Add them to the transition
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        //Add them to the transition
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        //Add them to the transition
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        //Add them to the transition
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        //Add them to the transition
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        //To be used to add transitions and places to the petrinet
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        //Add places to the list
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        //Add transitions to the list
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        //Add transitions and places
        g.addTransitions(transitionsToAdd);
        g.addPlaces(placesToAdd);
        
        //Set start and end
        g.setStart(p1);
        g.setEnd(p7);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert start, end, size and that the petrinet contain all the elements
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd)
        		&& transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
    }
    
    /**
     * Tests a Graph with only a transition.
     * @throws petriNetException
     *
     */
    @Test
    public void testPetriNet2() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        
        //Add single transition
        g.addSingleTransition(t02);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert that only one element, being the transition, is in the petrinet
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.size() == 0);
    }
    
	/**
     * Tests a graph with only two places and a transition
     * @throws petriNetException
     *
     */
    @Test
    public void testPetriNet3() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        
        //Creates the places with incoming and outgoing transitions
        Place p01 = new Place( 1, new Point( 60, 170), true,  null, t02);
        Place p03 = new Place( 3, new Point(243, 114), false, t02,  null);
        
        //To be used to add places to the petrinet
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        //Add places to the list
        placesToAdd.add(p01);
        placesToAdd.add(p03);
        
        //Add the transition to the petrinet
        g.addSingleTransition(t02);
        
        //Add the places
        g.addPlaces(placesToAdd);
        
        //Set start and end
        g.setStart(p01);
        g.setEnd(p03);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert that only three elements is in the petrinet, 2 places and 1 transition
        //also assert start and end
        assertEquals(p03,g.getEnd());
        assertEquals(p01,g.getStart());
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.containsAll(placesToAdd) && places.size() == 2);
    }
    
    /**
     * Test removal of a transition
     * @throws petriNetException
     * 
     */
    @Test
    public void testPetriNet4() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        //Creates the places with incoming and outgoing transitions
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        //For adding incoming and outgoing places to the transitions
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        //Add them to the transition
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        //Add them to the transition
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        //Add them to the transition
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        //Add them to the transition
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        //Add them to the transition
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        //To be used to add transitions and places to the petrinet
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        //Add places to the list
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        //Add transitions to the list
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        //Add transitions and places
        g.addTransitions(transitionsToAdd);
        g.addPlaces(placesToAdd);
        
        //Set start and end
        g.setStart(p1);
        g.setEnd(p7);;
        
        //Remove a transition
        g.removeTransition(t5);
        transitionsToAdd.remove(t5);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert start, end, size and that the petrinet contain all the element
        //and assert that the proper places now have no incoming/outgoing transition
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd)
        		&& transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
        assertTrue(p7.getIncoming() == null && p6.getOutgoing() == null
        		&& p4.getOutgoing() == null);
    }
    
    /**
     * Test removal of two places
     * @throws petriNetException 
     *
     */
    @Test
    public void testPetriNet5() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        //Creates the places with incoming and outgoing transitions
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        //For adding incoming and outgoing places to the transitions
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        //Add them to the transition
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        //Add them to the transition
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        //Add them to the transition
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        //Add them to the transition
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        //Add them to the transition
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        //To be used to add transitions and places to the petrinet
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        //Add places to the list
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        //Add transitions to the list
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        //Add transitions and places
        g.addTransitions(transitionsToAdd);
        g.addPlaces(placesToAdd);
        
        //Set start and end
        g.setStart(p1);
        g.setEnd(p7);
        
        //remove two places
        g.removePlace(p3);
        g.removePlace(p4);
        placesToAdd.remove(p3);
        placesToAdd.remove(p4);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert start, end, size and that the petrinet contain all the element
        //and assert that the proper transitions now have fewer or none incoming/outgoing
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd)
        		&& transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
        assertTrue(t2.getOutgoing().isEmpty() && t3.getIncoming().isEmpty() &&
        		t3.getOutgoing().isEmpty() && t5.getIncoming().size() == 1
        		&& t5.getIncoming().contains(p6));
    }
    
    /**
     * Test removal of two places
     * @throws petriNetException 
     *
     */
    @Test
    public void testPetriNet6() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	//Create the transitions
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        //Creates the places with incoming and outgoing transitions
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        //For adding incoming and outgoing places to the transitions
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        //Add them to the transition
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        //Add them to the transition
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        //Add them to the transition
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        //Add them to the transition
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        //clear before use for next transition
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        //Add incoming and outgoing places to the lists
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        //Add them to the transition
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        //To be used to add transitions and places to the petrinet
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        //Add places to the list
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        //Add transitions to the list
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        //Add transitions and places
        g.addTransitions(transitionsToAdd);
        g.addPlaces(placesToAdd);
        
        //Set start and end
        g.setStart(p1);
        g.setEnd(p7);
        
        //toggle one token and set another
        p1.toggleToken();
        p2.setToken(true);
        
        //Get the transitions and places by the petrinet
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        //assert start, end, size and that the petrinet contain all the element
        //and that the token been toggled is now false and the one set is now true
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd)
        		&& transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
        assertTrue(!places.get(0).getToken() && places.get(1).getToken());
    }
}
