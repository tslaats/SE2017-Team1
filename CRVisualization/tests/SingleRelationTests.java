package tests;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.junit.Test;

import drawings.Condition;
import drawings.ConditionFlipped;
import drawings.ConditionStacked;
import drawings.ConditionStackedFlipped;
import drawings.Response;
import drawings.ResponseFlipped;
import drawings.ResponseStacked;
import drawings.ResponseStackedFlipped;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import utils.CRGVlib;
import utils.TestUtil;

import static org.junit.Assert.assertEquals;

public class SingleRelationTests {
	
	private static final String IMAGE_FORMAT = ".jpg";
	private CRGVlib crv = new CRGVlib();

    @Test
    public void testCond() throws Exception {
    	String fileNameExpected = "images/expected/cond";
        Condition graphExpected = new Condition();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/cond";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act2, act1, "cond");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testCondFlip() throws Exception {
    	String fileNameExpected = "images/expected/cond_flip";
        ConditionFlipped graphExpected = new ConditionFlipped();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/cond_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "cond");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testCondStack() throws Exception {
    	String fileNameExpected = "images/expected/cond_stack";
        ConditionStacked graphExpected = new ConditionStacked();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/cond_stack";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act2, act1, "cond");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testCondStackFlip() throws Exception {
    	String fileNameExpected = "images/expected/cond_stack_flip";
        ConditionStackedFlipped graphExpected = new ConditionStackedFlipped();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/cond_stack_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "cond");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testResp() throws Exception {
    	String fileNameExpected = "images/expected/resp";
        Response graphExpected = new Response();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/resp";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act2, act1, "resp");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testRespFlip() throws Exception {
    	String fileNameExpected = "images/expected/resp_flip";
        ResponseFlipped graphExpected = new ResponseFlipped();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/resp_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "resp");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testRespStack() throws Exception {
    	String fileNameExpected = "images/expected/resp_stack";
        ResponseStacked graphExpected = new ResponseStacked();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/resp_stack";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act1, act2, "resp");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testRespStackFlip() throws Exception {
    	String fileNameExpected = "images/expected/resp_stack_flip";
        ResponseStackedFlipped graphExpected = new ResponseStackedFlipped();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/resp_stack_flip";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
		graph.activities.add(act1);
		graph.activities.add(act2);
		ConresRelation relation = new ConresRelation(act2, act1, "resp");
		graph.relations.add(relation);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
}
