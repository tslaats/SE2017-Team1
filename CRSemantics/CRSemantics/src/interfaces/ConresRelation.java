package interfaces;

public interface ConresRelation {
    public ConresActivity parent;
    public ConresActivity child;
    public Type type;

    public ConresRelation(ConresActivity parent, ConresActivity child, Type type);

    public string toString();
}