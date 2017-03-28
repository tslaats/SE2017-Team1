package gui;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck
 *  @contact >> 
 *  @version >> 1.0.1
 *  @updated >> 21/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */


/**
 *  This is a actual class for relations in a condition response graph. The idea
 *  is that, rather than making derived instances of this class, we use the enum
 *  type, to handle what type of relation this is. Handling this enum could make
 *  less sense than derving the classes, but since we only have two types, it is
 *  a design choice that we tok. It also makes the unified model diagram, easier
 */
public class ConresRelation
{
    public ConresEvent                parent          = null;
    public ConresEvent                child           = null;
    public Type                       type            = null;
    
    /*
     *  This creates a new instance of a response-condition relation of the type
     *  supplied with the constructor. The enum exists inside this class and has
     *  to be referenced from the class specifier name rather than some instance
     */
    public ConresRelation (ConresEvent parent, ConresEvent child, Type type)
    {
        this.parent = parent;
        this.child  = child;
        this.type   = type;
    }
    
    public static enum Type
    {
        Condition,
        Response
    }
    
    /**
     *  This is a toString override. It creates a pretty print format of all the
     *  content. It even handles the cases where the start and end points appear
     *  as null values. It creates a nice multi-line formatted structure, whitch
     *  allows the user to visually inspect the data, and see how it appears, as
     *  a list. It does not format to any graph like image though. This is meant
     *  for debugging purposes, and for these reasons stringbuilder was not used
     *  even though it would be obvious. The format looks weird, but look at the
     *  course page, for a post about the format and how it looks after printing
     */
    public String toString ()
    {
        return ("Relation (parent: " + (parent == null ? "assigned" : "null") + ", child: " + (child == null ? "assigned" : "null") + ", type: " + (type == Type.Condition ? "condition" : "response") + ")");
    }
    
    public ConresEvent getParent() {
		return parent;
	}
	
	public void setParent(ConresEvent parent) {
		this.parent = parent;
	}
	
	public ConresEvent getChild() {
		return child;
	}
	
	public void setChild(ConresEvent child) {
		this.child = child;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
