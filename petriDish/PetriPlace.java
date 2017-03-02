// Af Emil S. Bak 2017 for SE

// Imports
import java.awt.Point;
//import java.lang.Object;

// The class
public class PetriPlace {

	Point pos;
	Boolean token;
	List<Transition> outgoing = new ArrayList<Transition>();
	List<Transition> incoming = new ArrayList<Transition>();
	String id;

	// The Constructor - Defines the input the object takes when created.
	public PetriPlace(Point consPos, Boolean consToken,List<Transition> consOutgoing,
		              List<Transition> consIncoming, String consId) {

		// Aur'this.' can possibly be removed
		this.setPos(consPos);
		this.setToken(consToken);
		this.setOutgoing(consOutgoing);
		this.setIncoming(consIncoming);
		this.setId(consId);
	}


	// SET Methods
	public void setPos(Point inputPos){
		this.pos = inputPos;
	}

	public void setToken(Boolean inputToken){
		this.token = inputToken;
	}

	public void setOutgoing(List<Transition> inputOutgoing){
		this.outgoing = inputOutgoing;
	}

	public void setIncoming(List<Transition> inputIncoming){
		this.incoming = inputIncoming;
	}

	public void setId(String inputId){
		this.id = inputId;
	}


	// GET methods
	public Point getPos(){
		return pos;
	}

	public Boolean getToken(){
		return token;
	}

	public List<Transition> getOutgoing(){
		return outgoing;
	}

	public List<Transition> getIncoming(){
		return incoming;
	}

	public String getId(){
		return id;
	}


}