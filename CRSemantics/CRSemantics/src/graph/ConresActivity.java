package graph;

import java.awt.Point;

import interfaces.Graph;

public class ConresActivity {
    public int id;
    public Point position;
    public String name;
    public String role;
    public boolean isExecuted;
    public boolean isPending;
    public Graph nestedGraph = null;

    public ConresActivity(int id, Point position, String name, String role, boolean isPending, Graph nestedGraph) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.role = role;
        this.isPending = isPending;
        this.nestedGraph = nestedGraph;
        this.isExecuted = false;
    }

    public ConresActivity(int id, Point position, String name, String role, boolean isPending) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.role = role;
        this.isPending = isPending;
        this.isExecuted = false;
    }

    @Override
    public String toString() {
        return " ";
    }
}