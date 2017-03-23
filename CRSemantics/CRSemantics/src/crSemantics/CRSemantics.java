package crSemantics;

import java.util.ArrayList;
import java.util.List;

import graph.ConresActivity;
import graph.ConresGraph;
import graph.Type;
import interfaces.Graph;
import interfaces.Semantics;
import utils.SemanticsFactory;

public class CRSemantics implements Semantics {
	
	public SemanticsFactory semanticsFactory = null;
	
	public CRSemantics(){	
		this.semanticsFactory = new SemanticsFactory();
	}

	/***
    public boolean isExecutable(ConresGraph graph, int id) {
        for(int i = 0; i < graph.activities.size(); i++) {
            if(graph.activities.get(i).id == id)
                // what if multiple ConresActivities have the same id?
                // not our problem
                return isExecutable(graph, graph.activities.get(i));
        }
    }
***/
	
    public boolean isExecutable(ConresGraph graph, ConresActivity activity) {
        for(int i = 0; i < graph.relations.size(); i++) {
            if(graph.relations.get(i).type == Type.CONDITION)
                // this definitely needs to be tested. object equivalence
                if (graph.relations.get(i).child == activity)
                    if(graph.relations.get(i).parent.isPending || !graph.relations.get(i).parent.isExecuted)
                        return false;
        }
        return true;
    }
    
    @Override
    public List<Integer> getPossibleActions(Graph graph) throws Exception {
    	ConresGraph crGraph = null;
    	try{
    		crGraph = (ConresGraph)graph;
    	}catch(Exception e){
    		throw new Exception("This is not a CRGraph");
    	}
        List<Integer> actions = new ArrayList<Integer>();
        for(int i = 0; i < crGraph.activities.size(); i++) {
            if(!crGraph.activities.get(i).isExecuted && isExecutable(graph, crGraph.activities.get(i).id))
                actions.add(crGraph.activities.get(i).id);
        }
        return actions;
    }

    /**
     * Doing it this way, it's possible that no events are executed
     * Maybe there should be a check if all events are in our graph
     */

    @Override
    public ConresGraph executeAction(Graph graph, List<Integer> ids) throws Exception {
    	ConresGraph crGraph = null;
    	try{
    		crGraph = (ConresGraph)graph;
    	}catch(Exception e){
    		throw new Exception("This is not a CRGraph");
    	}
        for(int i = 0; i < ids.size(); i++) {
            for(int j = 0; j < crGraph.activities.size(); j++) {
                if(crGraph.activities.get(i).id == ids.get(i))
                    if(isExecutable(crGraph, ids.get(i)))
                    	crGraph.activities.get(i).isExecuted = true;
                    else
                        throw new Exception("Event not executable!!!!");
            }
        }
        return crGraph;
    }
    
    @Override
    public boolean isFinished(Graph graph) throws Exception {
    	ConresGraph crGraph = null;
    	try{
    		crGraph = (ConresGraph)graph;
    	}catch(Exception e){
    		throw new Exception("This is not a CRGraph");
    	}
        for(int i = 0; i < crGraph.activities.size(); i++)

        	// USE THE FACTORY
            if(crGraph.activities.get(i).isPending || !crGraph.activities.get(i).nestedGraph.isFinished())
                return false;
        return true;
    }

}
