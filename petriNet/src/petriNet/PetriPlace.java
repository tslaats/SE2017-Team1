package petriNet;
// Af Emil S. Bak 2017 for SE

// Imports
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

//import java.lang.Object;
import petriNet.PetriTransition;

// The class
public class PetriPlace {

    Point pos;
    Boolean token;
    List<PetriTransition> outgoing = new ArrayList<PetriTransition>();
    List<PetriTransition> incoming = new ArrayList<PetriTransition>();
    String id;

    // The Constructor - Defines the input the object takes when created.
    public PetriPlace(Point consPos, Boolean consToken,List<PetriTransition> consOutgoing,
                      List<PetriTransition> consIncoming, String consId) {

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

    public void setOutgoing(List<PetriTransition> inputOutgoing){
        this.outgoing = inputOutgoing;
    }

    public void setIncoming(List<PetriTransition> inputIncoming){
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

    public List<PetriTransition> getOutgoing(){
        return outgoing;
    }

    public List<PetriTransition> getIncoming(){
        return incoming;
    }
    
    public String getId(){
        return id;
    }


}

