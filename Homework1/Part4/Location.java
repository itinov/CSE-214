package Homework1.Part4;


/* Location class */
public class Location {
	
	// variables for x and y coordinates 
	private int x;
	private int y;

	/* Location constructor that accepts x and y coordinates as ints */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* setter and getter methods for the x and y coordinates below */
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

}
