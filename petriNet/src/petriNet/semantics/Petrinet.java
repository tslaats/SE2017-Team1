package petriNet.semantics;

import petriNet.semantics.common.interfaces.Graph;
import petriNet.semantics.common.interfaces.Semantics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Some methods return the same instance to enable "chaining"
 *
 * Created by Mihai on 3/9/2017.
 */
public class Petrinet implements Semantics<Place> {

	/**
	 * Start of the Petrinet
	 */
	private Place start;

	/**
	 * End of the Petrinet
	 */
	private Place end;

	/**
	 * List of transitions
	 */
	private final List<Transition> transitions = new ArrayList<>();

	/**
	 * List of all the places in the Petrinet
	 */
	private final List<Place> places = new ArrayList<>();

	/**
	 * Class singleton instance
	 */
	private static Petrinet instance = null;

	/**
	 * Singleton constructor
	 */
	protected Petrinet() {
		// Exists only to defeat instantiation.
	}

	/**
	 * Returns the starting place of the Petrinet
	 *
	 * @return Place
	 */
	public Place getStart() {
		return start;
	}

	/**
	 * Sets the start place of the Petrinet
	 * 
	 * @param start
	 */
	public void setStart(Place start) {
		this.start = start;
	}

	/**
	 * Get the end Place of the Petrinet
	 *
	 * @return Place
	 */
	public Place getEnd() {
		return end;
	}

	/**
	 * Sets the end place of the Petrinet
	 *
	 * @param end
	 */
	public void setEnd(Place end) {
		this.end = end;
	}

	/**
	 * Return the list of transitions
	 *
	 * @return List<Transition>
	 */
	public List<Transition> getTransitions() {
		return transitions;
	}

	/**
	 * Adds a single transition
	 *
	 * @param Transition
	 * @return Petrinet
	 */
	public Petrinet addTransition(Transition transition) {
		transitions.add(transition);
		return this;
	}

	/**
	 * Adds multiple transitions
	 *
	 * @param transitions
	 * @return Petrinet
	 */
	public Petrinet addTransitions(List<Transition> transitions) {
		this.transitions.addAll(transitions);
		return this;
	}

	/**
	 * Returns the list of places
	 *
	 * @return List<Place>
	 */
	public List<Place> getPlaces() {
		return places;
	}

	/**
	 * Adds a single place
	 *
	 * @param place
	 * @return Petrinet
	 */
	public Petrinet addPlace(Place place) {
		places.add(place);
		return this;
	}

	/**
	 * Adds multiple places
	 *
	 * @param places
	 * @return List<Place>
	 */
	public Petrinet addPlace(List<Place> places) {
		this.places.addAll(places);
		return this;
	}

	// TODO
	@Override
	public List<Place> getPossibleActions() {
		boolean token = false;
		Transition trans = null;
		Iterator<Place> it = places.iterator();
		while (!token && it.hasNext()) {
			Place i = it.next();
			if (i.token) {
				token = true;
				trans = i.outgoing;
			}
		}
		if (trans != null) {
			if (trans.graph.check()) {
				return trans.outgoing;
			}
		}
		return null;
	}

	// TODO
	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public Graph executeAction(Place place) {
		// TODO Auto-generated method stub
		return null;
	}
}
