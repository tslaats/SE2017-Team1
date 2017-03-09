package petriNet.semantics.interfaces;

import java.util.List;

public interface Semantics {
	
	public List<GraphObject> getPossibleActions(Graph graph);

	public Graph executeAction(Graph graph, List<String> ids);
	
	public boolean isFinished(Graph graph);
}
