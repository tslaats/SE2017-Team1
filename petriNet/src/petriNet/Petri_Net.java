package petriNet;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
 
public class Petri_Net {
	PetriPlace start;
	PetriPlace end;
	List<PetriTransition> transitions = new ArrayList<PetriTransition>();
	List<PetriPlace> places = new ArrayList<PetriPlace>();

	public Petri_Net(PetriPlace start, PetriPlace end, List<PetriTransition> transitions, List<PetriPlace> places) {
		this.setStart(start);
		this.setEnd(end);
		this.setTransitions(transitions);
		this.setPlaces(places);
	}
	
	public void setStart(PetriPlace start) {
		this.start = start;
	}
	
	public void setEnd(PetriPlace end) {
		this.end = end;
	}
	
	public void setTransitions(List<PetriTransition> transitions) {
		this.transitions = transitions;
	}
	
	public void setPlaces(List<PetriPlace> places) {
		this.places = places;
	}
	
	public void place_to_transition(PetriPlace P, PetriTransition T){		
	}
	public void transition_to_place(PetriTransition T, PetriPlace P){
	}

}
