package graph;

public class ConresActivity {
    public int id;
    public Point position;
    public String name;
    public String role;
    public boolean isExecuted;
    public boolean isPending;

    public ConresActivity(int id, Point position, String name, String role, boolean isPending){
        this.id = id;
        this.position = position;
        this.name = name;
        this.role = role;
        this.isPending = isPending;
        this.isExecuted = false;
    }

    public String toString(){

    }
}