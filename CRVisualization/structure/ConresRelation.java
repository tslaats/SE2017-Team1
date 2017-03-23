package structure;

public class ConresRelation {
	private ConresActivity parent;
	private ConresActivity child;
	private String type;
	
	public ConresRelation(ConresActivity parent, ConresActivity child, String type){
		this.setParent(parent);
		this.setChild(child);
		this.setType(type);
	}
	
	public ConresActivity getParent() {
		return parent;
	}
	
	public void setParent(ConresActivity parent) {
		this.parent = parent;
	}
	
	public ConresActivity getChild() {
		return child;
	}
	
	public void setChild(ConresActivity child) {
		this.child = child;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
