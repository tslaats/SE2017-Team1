package tests;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.junit.Test;

import drawings.ActivityBasic;
import drawings.ActivityBasicPetri;
import drawings.ActivityExecuted;
import drawings.ActivityExecutedPetri;
import drawings.ActivityFull;
import drawings.ActivityFullPetri;
import drawings.ActivityPending;
import drawings.ActivityPendingPetri;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import utils.CRGVlib;
import utils.TestUtil;

import static org.junit.Assert.assertEquals;

public class SingleActivityTests {
	
	private static final String IMAGE_FORMAT = ".jpg";
	private CRGVlib crv = new CRGVlib();
	
    @Test
    public void testActBasic() throws Exception {
    	String fileNameExpected = "images/expected/act";
        ActivityBasic graphExpected = new ActivityBasic();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, false, false);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActBasicPetri() throws Exception {
    	String fileNameExpected = "images/expected/act_petri";
        ActivityBasicPetri graphExpected = new ActivityBasicPetri();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_petri";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, false, true);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    
    @Test
    public void testActExec() throws Exception {
    	String fileNameExpected = "images/expected/act_exec";
        ActivityExecuted graphExpected = new ActivityExecuted();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_exec";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, false, false);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActExecPetri() throws Exception {
    	String fileNameExpected = "images/expected/act_exec_petri";
        ActivityExecutedPetri graphExpected = new ActivityExecutedPetri();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_exec_petri";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, false, true);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActPend() throws Exception {
    	String fileNameExpected = "images/expected/act_pend";
        ActivityPending graphExpected = new ActivityPending();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_pend";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, true, false);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActPendPetri() throws Exception {
    	String fileNameExpected = "images/expected/act_pend_petri";
        ActivityPendingPetri graphExpected = new ActivityPendingPetri();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_pend_petri";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, true, true);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActFull() throws Exception {
    	String fileNameExpected = "images/expected/act_full";
        ActivityFull graphExpected = new ActivityFull();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_full";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, true, false);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
    
    @Test
    public void testActFullPetri() throws Exception {
    	String fileNameExpected = "images/expected/act_full_petri";
        ActivityFullPetri graphExpected = new ActivityFullPetri();
        TestUtil.drawAndSave(graphExpected, fileNameExpected);
        
        String fileNameGenerated = "images/generated/act_full_petri";
        ConresGraph graph = new ConresGraph();
		graph.activities = new ArrayList<ConresActivity>();
		graph.relations = new ArrayList<ConresRelation>();
		ConresActivity act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, true, true);
		graph.activities.add(act);
		JPanel graphGenerated = crv.draw(graph);
        TestUtil.drawAndSave(graphGenerated, fileNameGenerated);
    	
    	String cs1 = TestUtil.getChecksum(fileNameExpected + IMAGE_FORMAT);
    	String cs2 = TestUtil.getChecksum(fileNameGenerated + IMAGE_FORMAT);
    	assertEquals(cs1, cs2);
    }
}
