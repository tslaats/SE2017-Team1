package petriNet;
import java.awt.Point;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class PetriTransition {

	String name; //name of the transition
	
	Point pos; //(x,y) position of transition.
	
	String key; //key of the element
	
	List<PetriPlace> outgoing = new ArrayList<PetriPlace>();;
	
	List<PetriPlace> ingoing = new ArrayList<PetriPlace>();;
	
	public PetriTransition(String name, Point pos, List<PetriPlace> outgoing, List<PetriPlace> ingoing) {
		this.setName(name);
		this.setPosition(pos);
		this.setOutgoing(outgoing);
		this.setIngoing(ingoing);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(Point pos) {
		this.pos = pos;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setOutgoing(List<PetriPlace> outgoing) {
		this.outgoing = outgoing;
	}
	
	public void setIngoing(List<PetriPlace> ingoing) {
		this.ingoing = ingoing;
	}
	
	public String getName() {
		return name;
	}
	
	public Point getPosition() {
		return pos;
	}
	
	public String getKey() {
		return key;
	}
	
	public List<PetriPlace> getOutgoing() {
		return outgoing;
	}
	
	public List<PetriPlace> getIngoing() {
		return ingoing;
	}
}
