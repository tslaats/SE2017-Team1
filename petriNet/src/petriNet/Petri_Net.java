package petriNet;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
 
public class Petri_Net {
	PetriPlace start;
	PetriPlace end;
	List<PetriTransition> transitions = new ArrayList<PetriTransition>();
	List<PetriPlace> places = new ArrayList<PetriPlace>();


	// Change this later, when size of objects have been decided.
	double box_width = 100; double box_height = 50;
	double circle_radius = 25;
	
	/* Function addArc() takes an array containing coordinates (x1,y1,x2,y2) 
	 * and two strings that indicate the type of the incoming and out-coming object ("T" or "P).
	 * The function then calculates the center of the objects and returns the coordinates.  
	 */
	public double[] addArc(double[] coords, String from, String to) {
		double[] arc_coords = new double[4];
		
		// Get coordinates for incoming object (x1, y1)
		if (from.equalsIgnoreCase("T")){
			arc_coords[0] = coords[0]+50;
			arc_coords[1] = coords[1]+25;
		}
		else if (from.equalsIgnoreCase("P")){
			arc_coords[0] = coords[0] - (circle_radius/2);
			arc_coords[1] = coords[1] - (circle_radius/2);
		}
		else{
			System.out.println("ERR: type not found");
			return arc_coords;
		}
		
		// Get coordinates for out-coming object (x2,y2)
		if (to.equalsIgnoreCase("T")){
			arc_coords[2] = coords[2]+50;
			arc_coords[3] = coords[3]+25;			
		}
		else if (to.equalsIgnoreCase("P")){
			arc_coords[2] = coords[2] - (circle_radius/2);
			arc_coords[3] = coords[3] - (circle_radius/2);			
		}
		else{
			System.out.println("ERR: type not found");
			return arc_coords;
		}		
		
		return coords;
	}
	
	
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
