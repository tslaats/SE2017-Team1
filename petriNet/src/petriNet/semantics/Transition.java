package petriNet.semantics;

import java.util.ArrayList;
import java.util.List;

import petriNet.semantics.common.interfaces.CrGraph;

import java.awt.Point;


public class Transition
{
    public int id = -1;
    public Point position = null;
    public String name = null;
    public ArrayList<Place> incoming = new ArrayList<Place>();
    public ArrayList<Place> outgoing = new ArrayList<Place>();
    public CrGraph graph;
    
  
    public Transition (int id, Point position, String name,CrGraph graph )
    {
        this.id = id;
        this.position = position;
        this.name = name;
        this.graph=graph;
        
        this.outgoing = (ArrayList<Place>) outgoing;
    }
    
    public void addIncoming (List<Place>incoming){
    	this.incoming =(ArrayList<Place>) incoming;
    }
    
    public void addOutgoing (List<Place>outgoing){
    	this.outgoing =(ArrayList<Place>) outgoing;
    }

    

}
