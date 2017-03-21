package structure;
import java.awt.Point;

public class Activity {
	private Point center;
	private String title = "default";
	private String body = "default";
	private Boolean pending = false;
	private Boolean executed = false;
	private Boolean hasPetri = false;

	// constructors
	public Activity(Point center, String title, String body, Boolean pending, Boolean executed, Boolean hasPetri) {
		this.center = center;
		this.title = title;
		this.body = body;
		this.pending = pending;
		this.executed = executed;
		this.hasPetri = hasPetri;
	}
	public Activity(Point center, String title, String body) {
		this.center = center;
		this.title = title;
		this.body = body;
	}
	public Activity(Point center) {
		this.center = center;
	}

	//for comparing activities, an activity is defined by its title only which is probably not ideal...?
	@Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Activity)) {
            return false;
       }
       final Activity other = (Activity) obj;
       if (other.getBody() == this.body) {
            return true;
       }
       return false;
    }
	//get center point;
	public Point getCenter() {
		return this.center;
	}
	// get executed status
	public Boolean getExecuted() {
		return this.executed;
	}
	// get pending status
	public Boolean getPending() {
		return this.pending;
	}
	// get petri status
	public Boolean containsPetri() {
		return this.hasPetri;
	}
	// get title string
	public String getTitle() {
		return this.title;
	}
	// get description/body string
	public String getBody() {
		return this.body;
	}
}