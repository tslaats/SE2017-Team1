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
        
        Transition t1 = new Transition( 2, new Point(150, 250), "Receive order");
        Transition t2 = new Transition( 5, new Point(250, 100), "Ship order");
        Transition t3 = new Transition( 7, new Point(350, 100), "Questionnaire");
        Transition t4 = new Transition( 8, new Point(300, 400), "Send invoice");
        Transition t5 = new Transition(11, new Point(450, 250), "Receive payment");
        
        
        Place p1 = new Place( 1, new Point( 100, 250), true,  null, t1);
        Place p2 = new Place( 3, new Point(200, 100), false, t1,  t2);
        Place p3 = new Place( 4, new Point(300, 100), false, t2,  t3);
        Place p4 = new Place( 6, new Point(400, 100), false, t3,  t5);
        Place p5 = new Place( 9, new Point(200, 400), false, t1,  t4);
        Place p6 = new Place(10, new Point(400, 400), false, t4,  t5);
        Place p7 = new Place(12, new Point(500, 250), false, t5,  null);
        
        ArrayList<Place> incomingPlaces = new ArrayList<Place>();
        ArrayList<Place> outgoingPlaces = new ArrayList<Place>();
        
        incomingPlaces.add(p1);
        outgoingPlaces.add(p2);
        outgoingPlaces.add(p5);
        
        t1.addIncoming(incomingPlaces);
        t1.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear(); outgoingPlaces.clear();
        
        incomingPlaces.add(p2);
        outgoingPlaces.add(p3);
        
        t2.addIncoming(incomingPlaces);
        t2.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear(); outgoingPlaces.clear();
        
        incomingPlaces.add(p3);
        outgoingPlaces.add(p4);
        
        t3.addIncoming(incomingPlaces);
        t3.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear(); outgoingPlaces.clear();
        
        incomingPlaces.add(p5);
        outgoingPlaces.add(p6);
        
        t4.addIncoming(incomingPlaces);
        t4.addOutgoing(outgoingPlaces);
        
        incomingPlaces.clear(); outgoingPlaces.clear();
        
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

        JFrame frame = new JFrame("Test");

        frame.add(g);
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}
