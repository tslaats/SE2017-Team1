package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
    CRSemantics crSemantics;
    static int numberOfTestEvents = 1000;

    @Before
    public void setUp() {
        ConresActivity elicitActivity = new ConresActivity(0, new Point(0, 0), "Elicit Requirements", "role", false);
        designActivity = new ConresActivity(1, new Point(0, 0), "Design System", "role", false);
        implementActivity = new ConresActivity(2, new Point(0, 0), "Implement System", "role", true);
        ConresActivity changeRequestActivity = new ConresActivity(3, new Point(0, 0), "Change Request", "role", false);

        List<ConresActivity> activityList = new ArrayList<>();
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
        List<ConresRelation> relationList = new ArrayList<>();
        relationList.add(elicitDesignRelation);
        relationList.add(designImplementRelation);
        relationList.add(implementChangeRelation);
        relationList.add(changeImplementRelation);

        testGraph = new ConresGraph(activityList, relationList);

        crSemantics = new CRSemantics();
    }

    @Test
    public void ExecuteAnInvalidAction() {
        // Try to execute an event that depends on another event to be executed
        // first
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(1);
        try {
            crSemantics.executeAction(testGraph, actionsToExecute);
        } catch (Exception e) {
            assertEquals(ExceptionTags.BlockingConditionException.toString(), e.getMessage());
            return;
        }
        assertTrue(false);
    }

    @Test
    public void ExecuteEmptyActionList() {
        // Try to execute with an empty list of ids
        try {
            crSemantics.executeAction(testGraph, new ArrayList<>());
        } catch (Exception e) {
            // System.out.println(testGraph == null);
            assertEquals(ExceptionTags.EmptyListException.toString(), e.getMessage());
            return;
        }
        assertTrue(false);
    }

    @Test
    public void ExecuteValidAction() throws Exception {
        // Try to execute an event that does not depend on another event to be
        // executed first
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(0);
        ConresGraph newGraph = crSemantics.executeAction(testGraph, actionsToExecute);
        assertTrue(newGraph.activities.get(0).isExecuted);
    }

    @Test
    public void ExecuteValidLoneAction() throws Exception {
        // Create a graph with one action, which should always be executable
        ConresActivity act = new ConresActivity(0, new Point(0, 0), "First event", "role", true);

        List<ConresActivity> activities = new ArrayList<>();
        activities.add(act);
        ConresGraph graph = new ConresGraph(activities, new ArrayList<>());

        // Try to execute a lone event
        List<Integer> actionsToExecute = new ArrayList<>();
        actionsToExecute.add(0);
        ConresGraph newGraph = crSemantics.executeAction(graph, actionsToExecute);
        assertTrue(newGraph.activities.get(0).isExecuted);
    }

    @Test
    public void TestIsFinished() throws Exception {
        // Execute all pending events and its condition relations
        for (int i = 0; i < 3; i++) {
            List<Integer> actionsToExecute = new ArrayList<>();
            actionsToExecute.add(i);
            crSemantics.executeAction(testGraph, actionsToExecute);
        }

        assertTrue(crSemantics.isFinished(testGraph));
    }

    @Test
    public void TestIsFinished2() throws Exception {
        // Execute 2 non-pending events. Leave pending events alone
        for (int i = 0; i < 2; i++) {
            List<Integer> actionsToExecute = new ArrayList<>();
            actionsToExecute.add(i);
            crSemantics.executeAction(testGraph, actionsToExecute);
        }

        assertFalse(crSemantics.isFinished(testGraph));
    }

    @Test
    public void TestIsFinished3() throws Exception {
        // Do nothing; leave pending events alone
        assertFalse(crSemantics.isFinished(testGraph));
    }

    @Test
    public void TestGetPossibleActions1() throws Exception {
        List<Integer> possibleActions = crSemantics.getPossibleActions(testGraph);
        assertTrue(possibleActions.contains(0));
        assertTrue(possibleActions.size() == 1);
    }

    @Test
    public void TestGetPossibleActions2() throws Exception {
        for (int i = 0; i < 3; i++) {
            List<Integer> actionsToExecute = new ArrayList<>();
            actionsToExecute.add(i);
            crSemantics.executeAction(testGraph, actionsToExecute);
            
            List<Integer> possibleActions = crSemantics.getPossibleActions(testGraph);
            assertTrue(possibleActions.contains(i+1));
            assertTrue(possibleActions.size() == 1);
        }
    }

    @Test
    public void TestGetPossibleActions3() throws Exception {
        for (int i = 0; i < 4; i++) {
            List<Integer> actionsToExecute = new ArrayList<>();
            actionsToExecute.add(i);
            crSemantics.executeAction(testGraph, actionsToExecute);
        }

        /*
         * Notice here that we do not return executed events as possible actions
         */
        List<Integer> possibleActions = crSemantics.getPossibleActions(testGraph);
        assertTrue(possibleActions.size() == 0);
    }

    @Test
    public void TestInvalidGraph() throws Exception {

    }

    /*
     * This is a performance test that makes sure that the time constraints are
     * complied with. For 25 events with no relations (at least not specified as
     * a requirement) it must not take more than one second to execute.
     */
    @Test
    public void TestPerformance() throws Exception {
        long start = System.currentTimeMillis();

        // Create graph with 1 main event and 24 others. No relations
        List<ConresActivity> activities = new ArrayList<>();
        ConresActivity mainActivity = new ConresActivity(0, new Point(0, 0), "Main activity", "Role", true);
        activities.add(mainActivity);
        for (int i = 1; i < 25; i++) {
            ConresActivity act = new ConresActivity(i, new Point(0, 0), "Name" + i, "Role", true);

            activities.add(act);
        }
        ConresGraph crGraph = new ConresGraph(activities, new ArrayList<>());

        while (!crSemantics.isFinished(crGraph)) {
            List<Integer> possibleActions = crSemantics.getPossibleActions(crGraph);
            for (int i = 0; i < possibleActions.size(); i++) {
                List<Integer> actionsToExecute = new ArrayList<>();
                actionsToExecute.add(possibleActions.get(i));
                crSemantics.executeAction(crGraph, actionsToExecute);
            }
        }
        assertTrue((System.currentTimeMillis() - start) < 1000);
    }

    /*
     * This test makes sure that the implementation does not consume too many
     * resources to have an excess amount of events and relations
     */
    @Test
    public void TestPerformanceOverkill() throws Exception {
        long start = System.currentTimeMillis();

        // Create graph with 1 main event and 24 others with a condition
        // relation to the main event
        List<ConresActivity> activities = new ArrayList<>();
        List<ConresRelation> relations = new ArrayList<>();
        ConresActivity mainActivity = new ConresActivity(0, new Point(0, 0), "Main activity", "Role", true);
        activities.add(mainActivity);
        for (int i = 1; i < numberOfTestEvents; i++) {
            ConresActivity act = new ConresActivity(i, new Point(0, 0), "Name" + i, "Role", true);
            ConresRelation rel = new ConresRelation(mainActivity, act, Type.CONDITION);

            activities.add(act);
            relations.add(rel);
        }
        ConresGraph crGraph = new ConresGraph(activities, relations);

        while (!crSemantics.isFinished(crGraph)) {
            List<Integer> possibleActions = crSemantics.getPossibleActions(crGraph);
            for (int i = 0; i < possibleActions.size(); i++) {
                List<Integer> actionsToExecute = new ArrayList<>();
                actionsToExecute.add(possibleActions.get(i));
                crSemantics.executeAction(crGraph, actionsToExecute);
            }
        }
        assertTrue((System.currentTimeMillis() - start) < 1000);
    }
}
