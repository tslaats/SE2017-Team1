package petriNet.semantics;

import java.awt.Point;


public class Place
{
    public int id = -1;
    public Point position = null;
    public boolean token = false;
    public Transition incoming = null;
    public Transition outgoing = null;
    
    public Place (int id, Point position, boolean token, Transition incoming, Transition outgoing)
    {
        this.id         = id;
        this.position   = position;
        this.token      = token;
        this.incoming   = incoming;
        this.outgoing   = outgoing;
    }
    
}
