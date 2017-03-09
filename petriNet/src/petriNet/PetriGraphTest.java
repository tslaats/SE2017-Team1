package petriNet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.awt.Point;


public class PetriGraphTest {

	/**
     * Tests a full PetriGraph.
     *
     */
    @Test
    public void testPetriGraph1() {
    	PetriGraph g = new PetriGraph();
        
        PetriTransition t02 = new PetriTransition( 2, new Point(109, 163), "Receive order");
        PetriTransition t05 = new PetriTransition( 5, new Point(206, 114), "Ship order");
        PetriTransition t07 = new PetriTransition( 7, new Point(350, 218), "Questionnaire");
        PetriTransition t08 = new PetriTransition( 8, new Point(405, 114), "Send invoice");
        PetriTransition t11 = new PetriTransition(11, new Point(655, 163), "Receive payment");
        
        g.transitions.add(t02);
        g.transitions.add(t05);
        g.transitions.add(t07);
        g.transitions.add(t08);
        g.transitions.add(t11);
        
        PetriPlace p01 = new PetriPlace( 1, new Point( 60, 170), true,  null, t02);
        PetriPlace p03 = new PetriPlace( 3, new Point(243, 114), false, t02,  t05);
        PetriPlace p04 = new PetriPlace( 4, new Point(243, 218), false, t02,  t07);
        PetriPlace p06 = new PetriPlace( 6, new Point(405, 120), false, t05,  t08);
        PetriPlace p09 = new PetriPlace( 9, new Point(577, 120), false, t08,  t11);
        PetriPlace p10 = new PetriPlace(10, new Point(577, 218), false, t07,  t11);
        PetriPlace p12 = new PetriPlace(12, new Point(789, 170), false, t11,  null);
        
        g.places.add(p01);
        g.places.add(p03);
        g.places.add(p04);
        g.places.add(p06);
        g.places.add(p09);
        g.places.add(p10);
        g.places.add(p12);
        
        g.start = p01;
        g.end = p12;
    }
    
    /**
     * Tests a PetriGraph with only a transition.
     *
     */
    @Test
    public void testPetriGraph2() {
    	PetriGraph g = new PetriGraph();
        
        PetriTransition t02 = new PetriTransition( 2, new Point(109, 163), "Receive order");
        
        g.transitions.add(t02);
    }
    
	/**
     * Tests a full PetriGraph.
     *
     */
    @Test
    public void testPetriGraph3() {
    	PetriGraph g = new PetriGraph();
        
        PetriTransition t02 = new PetriTransition( 2, new Point(109, 163), "Receive order");
        
        g.transitions.add(t02);
        
        PetriPlace p01 = new PetriPlace( 1, new Point( 60, 170), true,  null, t02);
        PetriPlace p03 = new PetriPlace( 3, new Point(243, 114), false, t02,  null);
        
        g.places.add(p01);
        g.places.add(p03);
        
        g.start = p01;
        g.end = p03;
    }
}
