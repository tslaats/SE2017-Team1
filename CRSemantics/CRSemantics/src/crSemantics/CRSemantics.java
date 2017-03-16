package crSemantics;

import java.util.ArrayList;
import java.util.List;

import interfaces.Graph;
import interfaces.Semantics;

public class CRSemantics implements Semantics {

    public bool isExecutable(Graph graph, int id) {
        ConresGraph crGraph = (ConresGraph)graph;
        for(int i = 0; i < crGraph.activities.size(); i++) {
            if(crGraph.activities[i].id == id)
                // what if multiple ConresActivities have the same id?
                // not our problem
                return isExecutable(graph, crGraph.activities[i]);
        }
    }

    public bool isExecutable(Graph graph, ConresActivity activity) {
        ConresGraph crGraph = (ConresGraph)graph;
        for(int i = 0; i < crGraph.relations.size(); i++) {
            if(crGraph.relations[i].type == Type.Condition)
                // this definitely needs to be tested. object equivalency
                if (crGraph.relations[i].child == activity)
                    if(crGraph.relations[i].parent.isPending || !crGraph.relations[i].parent.isExecuted)
                        return false;
        }
        return true;
    }

    @Override
    public List<int> getPossibleActions(Graph graph) throws Exception {
        List<int> actions = new ArrayList<int>();
        ConresGraph crGraph = (ConresGraph)graph;
        for(int i = 0; i < crGraph.activities.size(); i++) {
            if(!crGraph.activities[i].isExecuted && isExecutable(graph, crGraph.activities[i].id))
                actions.add(crGraph.actions[i].id);
        }
        return actions;
    }

    /**
     * Doing it this way, it's possible that no events are executed
     * Maybe there should be a check if all events are in our graph
     */
    @Override
    public Graph executeAction(Graph graph, List<int> ids) throws Exception {
        ConresGraph crGraph = (ConresGraph)graph;
        for(int i = 0; i < ids.size(); i++) {
            for(int j = 0; j < crGraph.activities.size(); j++) {
                if(crGraph.activities[j].id == ids[i])
                    if(isExecutable(graph, ids[i]))
                        crGraph.activities[i].isExecuted = true;
                    else
                        throw Exception("Event not executable!!!!");
            }
            return (Graph)crGraph;
        }
    }

    @Override
    public boolean isFinished(Graph graph) throws Exception {
        ConresGraph crGraph = (ConresGraph)graph;
        for(int i = 0; i < crGraph.activities.size(); i++)
            if(crGraph.activities[i].isPending || !crGraph.activities[i].graph.isFinished())
                return false;
        return true;
    }
}
