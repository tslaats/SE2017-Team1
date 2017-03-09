package interfaces;

import java.util.List;

public interface Semantics {
	
	public List<GraphObject> getPossibleActions(CrGraph graph);

	public CrGraph executeAction(CrGraph graph, List<String> ids);
	
	public boolean isFinished(CrGraph graph);
}
