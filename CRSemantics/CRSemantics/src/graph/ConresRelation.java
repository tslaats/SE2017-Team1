package graph;

public class ConresRelation {
    public ConresActivity parent;
    public ConresActivity child;
    public Type type;

    public ConresRelation(ConresActivity parent, ConresActivity child, Type type) {
        this.child = child;
        this.parent = parent;
        this.type = type;
    }

    public string toString();
}
