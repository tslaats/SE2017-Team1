package petriNet.visualization.petriNet;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 3/14/17.
 */
public class together extends JPanel{
    private PetriNet p_net;
    private ArrayList<draw_connection> connections;

    public together(PetriNet p_net){
        this.p_net = p_net;
    }

    private void gen_connection(HashMap map, Transition t){
	ArrayList<Place> incoming = t.getIncoming();
	ArrayList<Place> outgoing = t.getOutgoing();
	Point p = t.getPosition();
	
	System.out.println("incoming size is: " + incoming.size());
	System.out.println("outgoing size is: " + outgoing.size());
	
	for (int i = 0; i < incoming.size(); i++) {
			Point p_incoming = incoming.get(i).getPosition();//(map.get(incoming.get(i).getId())).getPosition();
		    draw_connection conn = new draw_connection(p_incoming, p, incoming.get(i).getId(), t.getId());
		    connections.add(conn);
	}
	for (int i = 0; i < outgoing.size(); i++) {
			Point p_outgoing = ((Place) map.get(outgoing.get(i))).getPosition();
			draw_connection conn = new draw_connection(p, p_outgoing, t.getId(), outgoing.get(i).getId());
			connections.add(conn);
		System.out.println("run: " + i);
	}
    }

    public void generate_connections(){
        ArrayList<draw_connection> list = new ArrayList<draw_connection>();
        ArrayList<Transition> transitions = p_net.getTransitions();
        ArrayList<Place> place = p_net.getPlaces();

        HashMap map = new HashMap(place.size() + transitions.size());
        HashMap used_id = new HashMap(place.size() + transitions.size());

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
            if (used_id.containsKey(t_id)){
                ;
            }
            else {
            	System.out.println(t);
            	gen_connection(map, t);
            	used_id.put(t_id, t_id);
            }
        }

    }


    @Override
    public void paint(Graphics g){
    	ArrayList<Transition> transitions = p_net.getTransitions();
    	ArrayList<Place> place = p_net.getPlaces();
	
    	System.out.println(connections.size());
    	/*for (int i = 0; i < connections.size(); i++) {
    		draw_connection c = connections.get(i);
    		c.paint(g);
    	}*/
    	/*for (int i = 0; i < transitions.size(); i++) {
    		//draw_transition c = transitions.get(i);
    		c.paint(g);
    	}*/
	
        
    }
}
