package tests;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import resources.MalformedGraphException;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import utils.CRGVlib;

public class ExceptionTests {
	
	private CRGVlib crv = new CRGVlib();

    @Test (expected = MalformedGraphException.class)
    public void testTooCloseResp() throws MalformedGraphException {
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(100, 85), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "resp");
		graph.relations.add(relation);
		crv.draw(graph);
    }
    
    @Test (expected = MalformedGraphException.class)
    public void testTooCloseCond() throws MalformedGraphException {
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(100, 85), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "cond");
		graph.relations.add(relation);
		crv.draw(graph);
    }
    
    @Test (expected = MalformedGraphException.class)
    public void testActNotExist() throws MalformedGraphException {
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		ConresActivity actNotAdded = new ConresActivity(2, new Point(450, 35), "Activity 3", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, actNotAdded, "cond");
		graph.relations.add(relation);
		crv.draw(graph);
    }
    
    @Test (expected = MalformedGraphException.class)
    public void testCondToItself() throws MalformedGraphException {
        ConresGraph graph = new ConresGraph();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, false, false);
		graph.activities = new ArrayList<ConresActivity>(Arrays.asList(act));
		ConresRelation rel = new ConresRelation(act, act, "cond");
		graph.relations = new ArrayList<ConresRelation>(Arrays.asList(rel));
		crv.draw(graph);
    }
}
