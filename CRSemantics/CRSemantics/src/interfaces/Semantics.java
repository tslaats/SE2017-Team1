package interfaces;

import java.util.List;

public interface Semantics {
	
	public List<Integer> getPossibleActions(Graph graph) throws Exception;

	public Graph executeAction(Graph graph, List<int> ids) throws Exception;
	
	public boolean isFinished(Graph graph) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
