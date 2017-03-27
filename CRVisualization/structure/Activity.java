package structure;
import java.awt.Point;

import resources.Constants;

public class Activity extends ConresActivity {
	private Point center;


	// constructors
	public Activity(Point position, String title, String body, Boolean pending, Boolean executed, Boolean hasPetri) {
		super(-1, position, title, body, pending, executed, hasPetri);
		int x = this.position.x + (Constants.ACTIVITY_WIDTH/2);
	  	int y = this.position.y + (Constants.ACTIVITY_HEIGHT/2);
	  	Point center = new Point(x,y); 
		this.center = center;
	}
	public Activity(Point position, String title, String body) {
		super(-1, position, title, body, false, false, false);
		int x = this.position.x + (Constants.ACTIVITY_WIDTH/2);
	  	int y = this.position.y + (Constants.ACTIVITY_HEIGHT/2);
	  	Point center = new Point(x,y); 
		this.center = center;
	}
	

	//for comparing activities, an activity is defined by its title only which is probably not ideal...?
	@Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Activity)) {
            return false;
       }
       final Activity other = (Activity) obj;
       if (other.getBody() == this.name) {
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
		return this.isExecuted;
	}
	// get pending status
	public Boolean getPending() {
		return this.isPending;
	}
	// get petri status
	public Boolean containsPetri() {
		return this.hasPetri;
	}
	// get title string
	public String getTitle() {
		return this.role;
	}
	// get description/body string
	public String getBody() {
		return this.name;
	}
}