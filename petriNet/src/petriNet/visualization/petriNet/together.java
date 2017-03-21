package petriNet.visualization;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 3/14/17.
 */
public class together extends JPanel{
    private Petri_Net p_net;
    private ArrayList<draw_connection> connections;

    public together(Petri_Net p_net){
        p_net = p_net;
    }

    private void gen_connection(HashMap map, Transition t){
	ArrayList incomming = t.getIncomming();
	ArrayList outgoing = t.getOutgoing();
	Point p = t.getPosition();
	
	for (int i = 0; i < incomming.size(); i++) {
	    Point p_incomming = map.get(incomming.get(i)).getPosition();
	    draw_connection conn = New draw_connection(Point p_incomming, Point p, int incomming.get(i), int t.getId());
	    connections.add(conn);
	}
	for (int i = 0; i < outgoing.size(); i++) {
	    Point p_outgoing = map.get(outgoing.get(i)).getPosition();
	    draw_connection conn = New draw_connection(Point p, Point p_outgoing, int t.get(i), int outgoing.getId());
	    connections.add(conn);
	}
    }

    public void generate_connections(){
        ArrayList<draw_connection> list = new ArrayList<Point>();
        ArrayList<Transition> transitions = p_net.transitions;
        ArrayList<Place> place = p_net.places;

        HashMap map = new HashMap(place.size() + transitions.size());
        HashMap used_id = new HashMap(place.size() + transitions.size());

        for (int i = 0; i < transitions.size(); i++) {
            Transition t = transitions.get(i);
            int t_id = t.getID();
            Point t_position = t.getPosition();
            map.put(int t_id, Point t_position);
        }
        for (int i = 0; i < place.size(); i++) {
            Place p = place.get(i);
            int p_id = t.getID();
            Point p_position = p.getPosition();
            map.put(int p_id, Point p_position);
        }
        for (int i = 0; i < transitions.size(); i++) {
            Transition _t = transitions.get(i);
            int t_id = _t.getID();
            if (used_id.containsKey(p_id)){
                ;
            } else {
		gen_connection(HashMap _map, Transition _t);
		used_id.put(int t_id, int t_id);
            }
        }

    }


    @Override
    public void paint(Graphics g){
	ArrayList<Transition> transitions = p_net.transitions;
        ArrayList<Place> place = p_net.places;
	
	for (int i = 0; i < connections.size(); i++) {
	    draw_connection c = connections.get(i);
	    c.paint(g);
	}
	for (int i = 0; i < transitions.size(); i++) {
	    draw_transition c = connections.get(i);
	    c.paint(g);
	}
	
        
    }
}
