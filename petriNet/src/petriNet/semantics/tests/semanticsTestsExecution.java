package petriNet.semantics.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import petriNet.semantics.Petrinet;
import petriNet.semantics.Place;
import petriNet.semantics.Transition;
import petriNet.semantics.common.interfaces.CrGraph;

public class semanticsTestsExecution {
	static Petrinet g = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		g = new Petrinet();
		CrGraph cr = new CrGraph();

		Transition t02 = new Transition(2, new Point(109, 163), "Receive order", cr);
		Transition t05 = new Transition(5, new Point(206, 114), "Ship order", cr);
		Transition t07 = new Transition(7, new Point(350, 218), "Questionnaire", cr);
		Transition t08 = new Transition(8, new Point(405, 114), "Send invoice", cr);
		Transition t11 = new Transition(11, new Point(655, 163), "Receive payment", cr);

		Place p01 = new Place(1, new Point(60, 170), true, null, t02);
		Place p03 = new Place(3, new Point(243, 114), false, t02, t05);
		Place p04 = new Place(4, new Point(243, 218), false, t02, t07);
		Place p06 = new Place(6, new Point(405, 120), false, t05, t08);
		Place p09 = new Place(9, new Point(577, 120), false, t08, t11);
		Place p10 = new Place(10, new Point(577, 218), false, t07, t11);
		Place p12 = new Place(12, new Point(789, 170), false, t11, null);

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

		ArrayList<Place> incoming2 = new ArrayList<Place>();
		ArrayList<Place> incoming5 = new ArrayList<Place>();
		ArrayList<Place> incoming7 = new ArrayList<Place>();
		ArrayList<Place> incoming8 = new ArrayList<Place>();
		ArrayList<Place> incoming11 = new ArrayList<Place>();

		incoming2.add(p01);
		incoming5.add(p03);
		incoming7.add(p04);
		incoming8.add(p06);
		incoming11.add(p09);
		incoming11.add(p10);

		t02.addIncoming(incoming2);
		t05.addIncoming(incoming5);
		t07.addIncoming(incoming7);
		t08.addIncoming(incoming8);
		t11.addIncoming(incoming11);

		ArrayList<Place> outgoing2 = new ArrayList<Place>();
		ArrayList<Place> outgoing5 = new ArrayList<Place>();
		ArrayList<Place> outgoing7 = new ArrayList<Place>();
		ArrayList<Place> outgoing8 = new ArrayList<Place>();
		ArrayList<Place> outgoing11 = new ArrayList<Place>();

		outgoing2.add(p03);
		outgoing2.add(p04);
		outgoing5.add(p06);
		outgoing7.add(p10);
		outgoing8.add(p09);
		outgoing11.add(p12);

		t02.addOutgoing(outgoing2);
		t05.addOutgoing(outgoing5);
		t07.addOutgoing(outgoing7);
		t08.addOutgoing(outgoing8);
		t11.addOutgoing(outgoing11);

		g.addTransitions(transitionsToAdd);

		g.addPlaces(placesToAdd);

		g.setStart(p01);
		g.setEnd(p12);

	
		
	}


		@Test
		public void testExecuteAction() {
			List<Place> possibleActions = g.getPossibleActions();

			Petrinet n = (Petrinet) g.executeAction(possibleActions.get(0));

			possibleActions = n.getPossibleActions();
			for (Place a : possibleActions) {
				assertTrue(a.id == 6);
			}

		}
	

}
