package graph;

import interfaces.Graph;

public class ConresActivity {
    public int id;
    public Point position;
    public String name;
    public String role;
    public boolean isExecuted;
    public boolean isPending;
    public Graph nestedGraph;

    public ConresActivity(int id, Point position, String name, String role);

    public String toString();
}
S