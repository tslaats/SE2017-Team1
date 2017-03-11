package petriNet.semantics.common.interfaces;

import java.util.List;

import petriNet.semantics.common.interfaces.Graph;


/**
 * This interface should be for temporary use so that we can do our implementation
 *
 * It should be removed when the impl is ready and the common one used instead
 */
public interface Semantics {
		
		public List<Graph> getPossibleActions(Graph graph);

		public Graph executeAction(Graph graph, List<String> ids);
		
		public boolean isFinished(Graph graph);
}
