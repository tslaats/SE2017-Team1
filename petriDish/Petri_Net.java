import java.awt.Point;
import java.util.*;

public class Petri_Net {
	PetriPlace start;
	PetriPlace end;
	List<Transition> transitions = new ArrayList<Transition>();
	List<PetriPlace> places      = new ArrayList<PetriPlace>();		
	
	// Define initial marking of Petri net
	public void initial_marking(Point xy){
		start.pos = xy;
	}	
	
	/*
	public Point get_current_position(){		
	}
	*/

	
	public void place_to_transition(PetriPlace P, Transition T){		
	}
	public void transition_to_place(Transition T, PetriPlace P){
	}

}
