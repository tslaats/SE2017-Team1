package structure;
import java.awt.Point;

public class Relation {
	private Activity parent;
	private Activity child;
	private Point outConnect = new Point(0,0);
	private Point inConnect = new Point(0,0);
	private String type;

	// constructors
	public Relation(Activity parent, Activity child, String type) {
		this.parent = parent;
		this.child = child;
		this.type = type;
	}

	public String getType() {
		return this.type;
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