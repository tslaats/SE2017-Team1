package tests;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import org.junit.Test;

import drawings.ComplexGraph;
import drawings.ResponseToItself;
import drawings.TwoRelations;
import drawings.TwoRelationsFlipped;
import drawings.TwoRelationsStacked;
import drawings.TwoRelationsStackedFlipped;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import utils.CRGVlib;
import utils.TestUtil;

import static org.junit.Assert.assertEquals;

public class ComplexRelationTests {
	
	private static final String IMAGE_FORMAT = ".jpg";
	private CRGVlib crv = new CRGVlib();

    @Test
    public void testTwoRels() throws Exception {
    	String fileNameExpected = "images/expected/two_rels";
    	TwoRelations graphExpected = new TwoRelations();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/two_rels";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation rel1 = new ConresRelation(act2, act1, "cond");
		ConresRelation rel2 = new ConresRelation(act1, act2, "resp");
		graph.relations.add(rel1);
		graph.relations.add(rel2);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testTwoRelsFlip() throws Exception {
    	String fileNameExpected = "images/expected/two_rels_flip";
    	TwoRelationsFlipped graphExpected = new TwoRelationsFlipped();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/two_rels_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation rel1 = new ConresRelation(act1, act2, "cond");
		ConresRelation rel2 = new ConresRelation(act2, act1, "resp");
		graph.relations.add(rel1);
		graph.relations.add(rel2);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testTwoRelsStack() throws Exception {
    	String fileNameExpected = "images/expected/two_rels_stack";
    	TwoRelationsStacked graphExpected = new TwoRelationsStacked();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/two_rels_stack";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation rel1 = new ConresRelation(act2, act1, "cond");
		ConresRelation rel2 = new ConresRelation(act1, act2, "resp");
		graph.relations.add(rel1);
		graph.relations.add(rel2);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testTwoRelsStackFlip() throws Exception {
    	String fileNameExpected = "images/expected/two_rels_stack_flip";
    	TwoRelationsStackedFlipped graphExpected = new TwoRelationsStackedFlipped();
    	TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/two_rels_stack_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation rel1 = new ConresRelation(act1, act2, "cond");
		ConresRelation rel2 = new ConresRelation(act2, act1, "resp");
		graph.relations.add(rel1);
		graph.relations.add(rel2);
		JPanel graphGenerated = crv.draw(graph);
		TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testComplex() throws Exception {
    	int canvasSize = 650;
    	
    	String fileNameExpected = "images/expected/complex";
    	ComplexGraph graphExpected = new ComplexGraph();
        TestUtil.drawAndSave(graphExpected, fileNameExpected, canvasSize);
        
        String fileNameGenerated = "images/generated/complex";
        ConresGraph graph = new ConresGraph();

		ConresActivity actNorth = new ConresActivity(0, new Point(250, 35), "North", "ROLE", false, false, false);
		ConresActivity actWest = new ConresActivity(1, new Point(50, 235), "West", "ROLE", false, false, false);
		ConresActivity actCenter = new ConresActivity(2, new Point(250, 235), "Center", "ROLE", false, false, false);
		ConresActivity actEast = new ConresActivity(3, new Point(450, 235), "East", "ROLE", false, false, false);
		ConresActivity actSouth = new ConresActivity(4, new Point(250, 435), "South", "ROLE", false, false, false);
		graph.activities = new ArrayList<ConresActivity>(
				Arrays.asList(actNorth, actWest, actCenter, actEast, actSouth));

		ConresRelation relN1 = new ConresRelation(actNorth, actCenter, "cond");
		ConresRelation relN2 = new ConresRelation(actCenter, actNorth, "resp");
		ConresRelation relW1 = new ConresRelation(actWest, actCenter, "cond");
		ConresRelation relW2 = new ConresRelation(actCenter, actWest, "resp");
		ConresRelation relE1 = new ConresRelation(actEast, actCenter, "cond");
		ConresRelation relE2 = new ConresRelation(actCenter, actEast, "resp");
		ConresRelation relS1 = new ConresRelation(actSouth, actCenter, "cond");
		ConresRelation relS2 = new ConresRelation(actCenter, actSouth, "resp");
		graph.relations = new ArrayList<ConresRelation>(
				Arrays.asList(relN1, relN2, relW1, relW2, relE1, relE2, relS1, relS2));
		
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated, canvasSize);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testRespToItself() throws Exception {
    	int canvasSize = 650;
    	
    	String fileNameExpected = "images/expected/resp_itself";
    	ResponseToItself graphExpected = new ResponseToItself();
        TestUtil.drawAndSave(graphExpected, fileNameExpected, canvasSize);
        
        String fileNameGenerated = "images/generated/resp_itself";
        ConresGraph graph = new ConresGraph();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, false, false);
		graph.activities = new ArrayList<ConresActivity>(Arrays.asList(act));
		ConresRelation rel = new ConresRelation(act, act, "resp");
		graph.relations = new ArrayList<ConresRelation>(Arrays.asList(rel));
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated, canvasSize);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void test1ToNRels() throws Exception {
    	int canvasSize = 650;
    	
//    	String fileNameExpected = "images/expected/resp_itself";
//    	ResponseToItself graphExpected = new ResponseToItself();
//        TestUtil.drawAndSave(graphExpected, fileNameExpected, canvasSize);
        
        String fileNameGenerated = "images/resps";
        ConresGraph graph = new ConresGraph();
        
		ConresActivity act = new ConresActivity(0, new Point(250, 235), "Activity", "ROLE", false, false, false);
		ConresActivity actLeft1 = new ConresActivity(1, new Point(50, 135), "Left 1", "ROLE", false, false, false);
		ConresActivity actLeft2 = new ConresActivity(2, new Point(50, 335), "Left 2", "ROLE", false, false, false);
		ConresActivity actRight1 = new ConresActivity(3, new Point(450, 135), "Right 1", "ROLE", false, false, false);
		ConresActivity actRight2 = new ConresActivity(4, new Point(450, 335), "Right 2", "ROLE", false, false, false);
		ConresActivity actUp1 = new ConresActivity(5, new Point(180, 35), "Up 1", "ROLE", false, false, false);
		ConresActivity actUp2 = new ConresActivity(7, new Point(320, 35), "Up 2", "ROLE", false, false, false);
		ConresActivity actDown1 = new ConresActivity(6, new Point(180, 435), "Down 1", "ROLE", false, false, false);
		ConresActivity actDown2 = new ConresActivity(8, new Point(320, 435), "Down 2", "ROLE", false, false, false);
		graph.activities = new ArrayList<ConresActivity>(
				Arrays.asList(act, actLeft1, actLeft2, actRight1, actRight2, actUp1, actUp2, actDown1, actDown2));
		
		ConresRelation resp = new ConresRelation(act, act, "resp");
		ConresRelation condLeft1 = new ConresRelation(act, actLeft1, "cond");
		ConresRelation respLeft1 = new ConresRelation(actLeft1, act, "resp");
		ConresRelation condLeft2 = new ConresRelation(act, actLeft2, "cond");
		ConresRelation respLeft2 = new ConresRelation(actLeft2, act, "resp");
		ConresRelation condRight1 = new ConresRelation(act, actRight1, "cond");
		ConresRelation respRight1 = new ConresRelation(actRight1, act, "resp");
		ConresRelation condRight2 = new ConresRelation(act, actRight2, "cond");
		ConresRelation respRight2 = new ConresRelation(actRight2, act, "resp");
		ConresRelation condUp1 = new ConresRelation(act, actUp1, "cond");
		ConresRelation respUp1 = new ConresRelation(actUp1, act, "resp");
		ConresRelation condUp2 = new ConresRelation(act, actUp2, "cond");
		ConresRelation respUp2 = new ConresRelation(actUp2, act, "resp");
		ConresRelation condDown1 = new ConresRelation(act, actDown1, "cond");
		ConresRelation respDown1 = new ConresRelation(actDown1, act, "resp");
		ConresRelation condDown2 = new ConresRelation(act, actDown2, "cond");
		ConresRelation respDown2 = new ConresRelation(actDown2, act, "resp");
		graph.relations = new ArrayList<ConresRelation>(Arrays.asList(resp, condLeft1, respLeft1,
				condLeft2, respLeft2, condRight1, respRight1, condRight2, respRight2, condUp1, respUp1,
				condUp2, respUp2, condDown1, respDown1, condDown2, respDown2));
		
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated, canvasSize);
//    	
//    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
//    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
//    	assertEquals(cs1, cs2);
    }
}
