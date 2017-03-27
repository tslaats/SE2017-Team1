package structure;

import java.awt.Point;

public class ConresActivity {
	public int id;
	private Point position;
	private String name;
	private String role;
	private Boolean isExecuted;
	private Boolean isPending;
	private Boolean hasPetri;
	
	public ConresActivity(int id, Point position, String name, String role, Boolean isExecuted, Boolean isPending, Boolean hasPetri){
		this.id = id;
		this.position = position;
		this.name = name;
		this.role = role;
		this.isExecuted = isExecuted;
		this.isPending = isPending;
		this.hasPetri = hasPetri;
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

	public Point getPosition() {
		return this.position;
	}
}
