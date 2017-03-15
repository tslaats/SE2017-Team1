package petriNet.semantics;

import petriNet.Graph;
import petriNet.semantics.common.interfaces.Semantics;

import java.util.*;
import java.util.function.Predicate;

/**
 * Some methods return the same instance to enable "chaining"
 *
 * Created by Mihai on 3/9/2017.
 */
public class Petrinet extends Graph implements Semantics<Place>  {

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
	public Petrinet() {
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
	 * @param transition
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
	public Petrinet addPlaces(List<Place> places) {
		this.places.addAll(places);
		return this;
	}

	@Override
	public List<Place> getPossibleActions() {
		// Better to return an empty list than null
		Predicate<Place> p = x -> x.token && x.outgoing.graph.isFinished();

		return places.stream().anyMatch(p) ? places.stream().filter(p).findFirst().get().outgoing.outgoing : Collections.emptyList();
	}

	@Override
	public boolean isFinished() {
		return places.stream().filter(x -> x.id == end.id).findFirst().map(p -> p.token).orElse(false);
	}

	@Override
	public Graph executeAction(Place place) {
		//we assume that the place asked is a valid place
		places.stream().filter(p -> p.token || p.id == place.id).forEach(p -> {
			p.token = !(p.token && p.id != place.id);
		});

		return this;
	}
}
