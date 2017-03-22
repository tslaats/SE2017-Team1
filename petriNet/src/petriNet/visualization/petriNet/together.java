import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 3/14/17.
 */
public class together extends JPanel{
    private PetriNet p_net;
    private ArrayList<drawConnection> connections;

    public together(PetriNet p_net){
        this.p_net = p_net;
        this.connections = new ArrayList<>();
    }

    private void genConnection(Transition t){
	ArrayList<Place> incoming = t.getIncoming();
	ArrayList<Place> outgoing = t.getOutgoing();
	Point p = t.getPosition();

	for (Place place : incoming) {
        Point pIncoming = place.getPosition();
        drawConnection conn = new drawConnection(pIncoming, p, place.getId(), t.getId());
        this.connections.add(conn);
	}
	for (Place place : outgoing) {
		Point pOutgoing = place.getPosition();
        drawConnection conn = new drawConnection(p, pOutgoing, t.getId(), place.getId());
        this.connections.add(conn);
	    }
    }

    public void generate_connections(){
        ArrayList<drawConnection> list = new ArrayList<>();
        ArrayList<Transition> transitions = p_net.getTransitions();
        ArrayList<Place> place = p_net.getPlaces();

        HashMap map = new HashMap(place.size() + transitions.size());
        HashMap usedId = new HashMap(place.size() + transitions.size());

        for (int i = 0; i < transitions.size(); i++) {
            Transition t = transitions.get(i);
            int t_id = t.getId();
            Point t_position = t.getPosition();
            map.put(t_id, t_position);
        }
        for (int i = 0; i < place.size(); i++) {
            Place p = place.get(i);
            int p_id = p.getId();
            Point p_position = p.getPosition();
            map.put(p_id, p_position);
        }
        for (int i = 0; i < transitions.size(); i++) {
            Transition t = transitions.get(i);
            int t_id = t.getId();
            if (usedId.containsKey(t_id)){
                ;
            }
            else {
            	genConnection(t);
            	usedId.put(t_id, t_id);
            }
        }

    }


    @Override
    public void paint(Graphics g){
    	ArrayList<Transition> transitions = p_net.getTransitions();
    	ArrayList<Place> place = p_net.getPlaces();

    	for (int i = 0; i < connections.size(); i++) {
            drawConnection c = connections.get(i);
    		c.paint(g);
    	}
    	for (int i = 0; i < transitions.size(); i++) {
    		drawTransition t = new drawTransition(transitions.get(i));
    		t.paint(g);
    	}
        for (int i = 0; i < place.size(); i++) {
            drawPlace p = new drawPlace(place.get(i));
            p.paint(g);
        }
    }
}
