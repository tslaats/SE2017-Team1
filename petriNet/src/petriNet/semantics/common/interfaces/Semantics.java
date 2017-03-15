package petriNet.semantics.common.interfaces;

import java.util.List;

import petriNet.Graph;


/**
 * This interface should be for temporary use so that we can do our implementation
 *
 * It should be removed when the impl is ready and the common one used instead
 */
public interface Semantics<T1> {
		
		public List<T1> getPossibleActions();

		public Graph executeAction(T1 object);
		
		public boolean isFinished();
}
