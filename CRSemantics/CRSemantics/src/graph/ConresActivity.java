package graph;

import interfaces.Graph;
import java.awt.Point;

public class ConresActivity {
    public int id;
    public Point position;
    public String name;
    public String role;
    public boolean isExecuted;
    public boolean isPending;
    public Graph nestedGraph;

    public ConresActivity(int id, Point position, String name, String role, boolean isPending, Graph nestedGraph){
        this.id = id;
        this.position = position;
        this.name = name;
        this.role = role;
        this.isPending = isPending;
        this.nestedGraph = nestedGraph;
        this.isExecuted = false;
    }

    public String toString(){
        return " ";
    }
}