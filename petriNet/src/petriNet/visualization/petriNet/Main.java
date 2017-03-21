package petriNet.visualization;

import java.util.ArrayList;
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
        
        g.transitions.add(t02);
        g.transitions.add(t05);
        g.transitions.add(t07);
        g.transitions.add(t08);
        g.transitions.add(t11);
        
        Place p01 = new Place( 1, new Point( 60, 170), true,  null, t02);
        Place p03 = new Place( 3, new Point(243, 114), false, t02,  t05);
        Place p04 = new Place( 4, new Point(243, 218), false, t02,  t07);
        Place p06 = new Place( 6, new Point(405, 120), false, t05,  t08);
        Place p09 = new Place( 9, new Point(577, 120), false, t08,  t11);
        Place p10 = new Place(10, new Point(577, 218), false, t07,  t11);
        Place p12 = new Place(12, new Point(789, 170), false, t11,  null);
        
        g.places.add(p01);
        g.places.add(p03);
        g.places.add(p04);
        g.places.add(p06);
        g.places.add(p09);
        g.places.add(p10);
        g.places.add(p12);
        
        g.start = p01;
        g.end   = p12;

        System.out.println(g);


        JFrame frame = new JFrame("Test");
        together p = new together(g);

    }
}
