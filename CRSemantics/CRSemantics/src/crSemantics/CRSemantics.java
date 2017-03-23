package crSemantics;

import java.util.ArrayList;
import java.util.List;

import graph.ConresActivity;
import graph.ConresGraph;
import graph.Type;
import interfaces.Graph;
import interfaces.Semantics;

public class CRSemantics implements Semantics {

    public boolean isExecutable(ConresGraph graph, int id) {
        for(int i = 0; i < graph.activities.size(); i++) {
            if(graph.activities.get(i).id == id)
                // what if multiple ConresActivities have the same id?
                // not our problem
                return isExecutable(graph, graph.activities.get(i));
        }
    }

    public boolean isExecutable(ConresGraph graph, ConresActivity activity) {
        for(int i = 0; i < graph.relations.size(); i++) {
            if(graph.relations.get(i).type == Type.CONDITION)
                // this definitely needs to be tested. object equivalency
                if (graph.relations.get(i).child == activity)
                    if(graph.relations.get(i).parent.isPending || !graph.relations.get(i).parent.isExecuted)
                        return false;
        }
        return true;
    }

    @Override
    public List<Integer> getPossibleActions(Graph graph) throws Exception {
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
