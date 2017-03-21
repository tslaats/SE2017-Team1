package petriNet.visualization.petriNet;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import java.awt.Point;

/*
 *  This file is an example, of the petri graph structure. It can be run without
 *  anything else. It manually setups the petri graph that has been shown in the
 *  lecture 3 slides, page 22 / 77. It creates the graph, and then pretty prints
 */
public class Main {

    public static void main (String[] args) {
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
        
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        incomingPlaces.add(p01);
        outgoingPlaces.add(p03);
        outgoingPlaces.add(p04);
        
        t02.addIncoming(incomingPlaces);
        t02.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p03);
        outgoingPlaces.add(p06);
        
        t05.addIncoming(incomingPlaces);
        t05.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p04);
        outgoingPlaces.add(p10);
        
        t07.addIncoming(incomingPlaces);
        t07.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p06);
        outgoingPlaces.add(p09);
        
        t08.addIncoming(incomingPlaces);
        t08.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear();
        outgoingPlaces.clear();
        
        incomingPlaces.add(p09);
        incomingPlaces.add(p10);
        outgoingPlaces.add(p12);
        
        t02.addIncoming(incomingPlaces);
        t02.addOutgoing(outgoingPlaces);
        
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
        
        Collection<Transition> transitions = g.getTransitions();
        Collection<Place> places = g.getPlaces();

        //System.out.println(transitions.size());


        JFrame frame = new JFrame("Test");
        together p = new together(g);
        p.generate_connections();
        
        frame.add(p);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}
