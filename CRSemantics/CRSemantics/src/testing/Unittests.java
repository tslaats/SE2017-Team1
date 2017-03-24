package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import crSemantics.CRSemantics;
import graph.ConresActivity;
import graph.ConresGraph;
import graph.ConresRelation;
import graph.Type;
import utils.ExceptionTags;

public class Unittests {

    ConresGraph testGraph;
    ConresActivity implementActivity;
    ConresActivity designActivity;

    protected void setUp() {
        ConresActivity elicitActivity = new ConresActivity(0, new Point(0, 0), "Elicit Requirements", "role", false);
        designActivity = new ConresActivity(1, new Point(0, 0), "Design System", "role", false);
        implementActivity = new ConresActivity(2, new Point(0, 0), "Implement System", "role", true);
        ConresActivity changeRequestActivity = new ConresActivity(3, new Point(0, 0), "Change Request", "role", false);

        ArrayList<ConresActivity> activityList = new ArrayList<ConresActivity>();
        activityList.add(elicitActivity);
        activityList.add(designActivity);
        activityList.add(implementActivity);
        activityList.add(changeRequestActivity);

        ConresRelation elicitDesignRelation = new ConresRelation(elicitActivity, designActivity, Type.CONDITION);
        ConresRelation designImplementRelation = new ConresRelation(designActivity, implementActivity, Type.CONDITION);
        ConresRelation implementChangeRelation = new ConresRelation(implementActivity, changeRequestActivity,
                Type.CONDITION);
        ConresRelation changeImplementRelation = new ConresRelation(changeRequestActivity, implementActivity,
                Type.RESPONSE);
        ArrayList<ConresRelation> relationList = new ArrayList<ConresRelation>();
        relationList.add(elicitDesignRelation);
        relationList.add(designImplementRelation);
        relationList.add(implementChangeRelation);
        relationList.add(changeImplementRelation);

        testGraph = new ConresGraph(activityList, relationList);
    }

    @Test
    public void ExecuteAnInvalidAction() {
        CRSemantics crSemantics = new CRSemantics();

        // Try to execute an event that depends on another event to be executed
        // first
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(1);
        try {
            crSemantics.executeAction(testGraph, actionsToExecute);
        } catch (Exception e) {
            assertEquals(e.getMessage(), ExceptionTags.BlockingConditionException);
            return;
        }
        assertTrue(false);
    }

    @Test
    public void ExecuteEmptyActionList() {
        // Create empty graph
        CRSemantics crSemantics = new CRSemantics();

        // Try to execute with an empty list of ids
        try {
            crSemantics.executeAction(new ConresGraph(new ArrayList<ConresActivity>(), new ArrayList<ConresRelation>()),
                    new ArrayList<Integer>());
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            assertEquals(e.getMessage(), ExceptionTags.EmptyListException.toString());
            return;
        }
        assertTrue(false);
    }

    @Test
    public void ExecuteValidAction() throws Exception {
        // Create a graph with one response relation connected to two activities

        ConresActivity act = new ConresActivity(0, new Point(2, 2), "First event", "role?", false);
        ConresActivity act2 = new ConresActivity(1, new Point(2, 2), "Second event", "role?", false);
        ConresRelation rel = new ConresRelation(act, act2, Type.RESPONSE);

        List<ConresActivity> actions = new ArrayList<>();
        List<ConresRelation> relations = new ArrayList<>();

        actions.add(act);
        actions.add(act2);
        relations.add(rel);
        ConresGraph graph = new ConresGraph(actions, relations);

        CRSemantics crSemantics = new CRSemantics();

        // Try to execute an event that does not depend on another event to be
        // executed first
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(0);
        ConresGraph newGraph = crSemantics.executeAction(testGraph, actionsToExecute);
        assertTrue(newGraph.activities.get(0).isExecuted);
    }

    @Test
    public void ExecuteValidLoneAction() throws Exception {
        // Create a graph with one relation connected to two activities
        ConresActivity act = new ConresActivity(0, new Point(0, 0), "First event", "role", true);

        List<ConresActivity> activities = new ArrayList<>();
        activities.add(act);
        ConresGraph graph = new ConresGraph(activities, new ArrayList<>());

        CRSemantics crSemantics = new CRSemantics();

        // Try to execute a lone event
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(0);
        ConresGraph newGraph = crSemantics.executeAction(graph, actionsToExecute);
        assertTrue(newGraph.activities.get(0).isExecuted);
    }
}
