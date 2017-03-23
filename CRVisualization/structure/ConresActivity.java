package structure;

import java.awt.Point;

public class ConresActivity {
	public int id;
	public Point position;
	public String name;
	public String role;
	public Boolean isExecuted;
	public Boolean isPending;
	public Boolean hasPetri;
	
	public ConresActivity(int id, Point position, String name, String role, Boolean isExecuted, Boolean isPending, Boolean hasPetri){
		this.id = id;
		this.position = position;
		this.name = name;
		this.role = role;
		this.isExecuted = isExecuted;
		this.isPending = isPending;
		this.hasPetri = hasPetri;
	}
}
