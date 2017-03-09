package petriNet.semantics.common.interfaces;

import java.util.List;

/**
 * This interface should be for temporary use so that we can do our implementation
 *
 * It should be removed when the impl is ready and the common one used instead
 */
public interface Semantics {
    public List<GraphObject> getPossibleActions(CrGraph graph);

    public CrGraph executeAction(CrGraph graph, List<String> ids);

    public boolean isFinished(CrGraph graph);
}
