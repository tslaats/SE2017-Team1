package petriNet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.awt.Point;


public class PetriNetTest {

	/**
     * Tests a full Graph.
     *
     */
    @Test
    public void testPetriNet1() {
    	PetriNet g = new PetriNet();
        
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        Transition t05 = new Transition( 5, new Point(206, 114), "Ship order");
        Transition t07 = new Transition( 7, new Point(350, 218), "Questionnaire");
        Transition t08 = new Transition( 8, new Point(405, 114), "Send invoice");
        Transition t11 = new Transition(11, new Point(655, 163), "Receive payment");
        
        Place p01 = new Place( 1, new Point( 60, 170), true,  null, t02);
        Place p03 = new Place( 3, new Point(243, 114), false, t02,  t05);
        Place p04 = new Place( 4, new Point(243, 218), false, t02,  t07);
        Place p06 = new Place( 6, new Point(405, 120), false, t05,  t08);
        Place p09 = new Place( 9, new Point(577, 120), false, t08,  t11);
        Place p10 = new Place(10, new Point(577, 218), false, t07,  t11);
        Place p12 = new Place(12, new Point(789, 170), false, t11,  null);
        
        ArrayList<Transition> transitionsToAdd = new ArrayList<Transition>();
        ArrayList<Place> placesToAdd = new ArrayList<Place>();
        
        placesToAdd.add(p01);
        placesToAdd.add(p03);
        placesToAdd.add(p04);
        placesToAdd.add(p06);
        placesToAdd.add(p09);
        placesToAdd.add(p10);
        placesToAdd.add(p12);
        
        transitionsToAdd.add(t02);
        transitionsToAdd.add(t05);
        transitionsToAdd.add(t07);
        transitionsToAdd.add(t08);
        transitionsToAdd.add(t11);
        
        g.addTransitions(transitionsToAdd);
        
        g.addPlaces(placesToAdd);
        
        g.setStart(p01);
        g.setEnd(p12);
        
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        assertEquals(p12,g.getEnd());
        assertEquals(p01,g.getStart());
        assertTrue(transitions.containsAll(transitionsToAdd) && transitions.size() == transitionsToAdd.size());
        assertTrue(places.containsAll(placesToAdd) && places.size() == placesToAdd.size());
    }
    
    /**
     * Tests a Graph with only a transition.
     *
     */
    @Test
    public void testPetriNet2() {
    	PetriNet g = new PetriNet();
        
        Transition t02 = new Transition( 2, new Point(109, 163), "Receive order");
        
        g.addSingleTransition(t02);
        
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.size() == 0);
    }
    
	/**
     * Tests a full Graph.
     *
     */
    @Test
    public void testPetriNet3() {
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
        
        ArrayList<Transition> transitions = g.getTransitions();
        ArrayList<Place> places = g.getPlaces();
        
        assertEquals(p03,g.getEnd());
        assertEquals(p01,g.getStart());
        assertTrue(transitions.contains(t02) && transitions.size() == 1);
        assertTrue(places.containsAll(placesToAdd) && places.size() == 2);
    }
}
