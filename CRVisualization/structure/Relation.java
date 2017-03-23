package structure;
import java.awt.Point;

public class Relation extends ConresRelation {
	private Activity parent;
	private Activity child;
	private Point outConnect = new Point(0,0);
	private Point inConnect = new Point(0,0);

	// constructors
	public Relation(Activity parent, Activity child, String type) {
		super(parent, child, type);
		this.parent = parent;
		this.child = child;
	}

	public Activity getParent() {
		return this.parent;
	}
	public Activity getChild() {
		return this.child;
	}
	public Point getIn() {
		return inConnect;
	}
	public void setIn(Point in) {
		inConnect = in;
	}
	public Point getOut() {
		return outConnect;
	}
	public void setOut(Point out) {
		outConnect = out;
	}
}