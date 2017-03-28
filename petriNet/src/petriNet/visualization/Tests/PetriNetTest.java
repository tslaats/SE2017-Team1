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
     *
     */
    @Test
    public void testPetriNet1() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        g.addTransitions(transitionsToAdd);
        
        g.addPlaces(placesToAdd);
        
        g.setStart(p1);
        g.setEnd(p7);
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();
        
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd) && transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
    }
    
    /**
     * Tests a Graph with only a transition.
     *
     */
    @Test
    public void testPetriNet2() throws petriNetException {
    	PetriNet g = new PetriNet();
        
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        
        g.addSingleTransition(t02);
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();
        
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.size() == 0);
    }
    
	/**
     * Tests a full Graph.
     *
     */
    @Test
    public void testPetriNet3() throws petriNetException {
    	PetriNet g = new PetriNet();
        
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        
        Place p01 = new Place( 1, new Point( 60, 170), true,  null, t02);
        Place p03 = new Place( 3, new Point(243, 114), false, t02,  null);
        
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        placesToAdd.add(p01);
        placesToAdd.add(p03);
        
        g.addSingleTransition(t02);
        
        g.addPlaces(placesToAdd);
        
        g.setStart(p01);
        g.setEnd(p03);
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();
        
        assertEquals(p03,g.getEnd());
        assertEquals(p01,g.getStart());
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.containsAll(placesToAdd) && places.size() == 2);
    }
    
    /**
     * Test removal of a transition
     *
     */
    @Test
    public void testPetriNet4() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        g.addTransitions(transitionsToAdd);
        
        g.addPlaces(placesToAdd);
        
        g.setStart(p1);
        g.setEnd(p7);
        
        g.removeTransition(t5);
        transitionsToAdd.remove(t5);
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();
        
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd) && transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
        assertTrue(p7.getIncoming() == null && p6.getOutgoing() == null && p4.getOutgoing() == null);
    }
    
    /**
     * Test removal of two places
     * @throws petriNetException 
     *
     */
    @Test
    public void testPetriNet5() throws petriNetException {
    	PetriNet g = new PetriNet();
        
    	Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(350, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(550, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(450, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(1000, 250), "Receive payment");
        
        
        Place p1 = new Place( 1, new Point( 50, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(250, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(450, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(700, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(250, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(700, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(1150, 250), false, t5,  null);
        
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p4);
        incomingPlaces.add(p6);
        outgoingPlaces.add(p7);
        
        t5.addIncoming(incomingPlaces);
        t5.addOutgoing(outgoingPlaces);
        
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        placesToAdd.add(p1);
        placesToAdd.add(p2);
        placesToAdd.add(p3);
        placesToAdd.add(p4);
        placesToAdd.add(p5);
        placesToAdd.add(p6);
        placesToAdd.add(p7);
        
        transitionsToAdd.add(t1);
        transitionsToAdd.add(t2);
        transitionsToAdd.add(t3);
        transitionsToAdd.add(t4);
        transitionsToAdd.add(t5);
        
        g.addTransitions(transitionsToAdd);
        
        g.addPlaces(placesToAdd);
        
        g.setStart(p1);
        g.setEnd(p7);
        
        g.removePlace(p3);
        g.removePlace(p4);
        placesToAdd.remove(p3);
        placesToAdd.remove(p4);
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();
        
        assertEquals(p1,g.getStart());
        assertEquals(p7,g.getEnd());
        assertTrue(transitions.containsAll(transitionsToAdd) && transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
        assertTrue(t2.getOutgoing().isEmpty() && t3.getIncoming().isEmpty() &&
        		t3.getOutgoing().isEmpty() && t5.getIncoming().size() == 1
        		&& t5.getIncoming().contains(p6));
    }
}
