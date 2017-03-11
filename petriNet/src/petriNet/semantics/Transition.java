package petriNet.semantics;

import java.util.ArrayList;

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
    }
    

    

}
