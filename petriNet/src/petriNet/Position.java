package petriNet;

public class Position {

	Integer x;
	Integer y;
	
	public Position(Integer x, Integer y) {
		this.setPosition(x,y);
	}
	
	public void setPosition(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Position getPosition(){
		return new Position (x,y);
	}

}
