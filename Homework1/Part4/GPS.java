package Homework1.Part4;


/* GPS class */
public class GPS { 
	
	// variables
	private Location myCurrentLocation;
	private Location myDestination;
	// Car constructor is called thru car variable
	Car car = new Car();
	
	/* setCurrentLocation method to set the current location from Location class */
	public void setCurrentLocation(Location myCurrentLocation) {
		this.myCurrentLocation = myCurrentLocation;
	}

	/* setDestination method to set the current destination from Location class */
	public void setDestination(Location myDestination) {
		this.myDestination = myDestination;
	}
	
	/* getCurrentLocation method to return current location */
	public Location getCurrentLocation() {
		return myCurrentLocation;
	}
	
	/* getDestination method to return current destination */
	public Location getDestination() {
		return myDestination;
	}

	/* getCalculatedDistance method that accepts 2 Location variables for current location and destination */
	public double getCalculatedDistance(Location myCurrentLocation, Location myDestination) {
		
		// variables 
		double xCoordinates;
		double yCoordinates;
		double var_squared;
		
		// Formula: distance = sqrt((x1-x2)^2 + (y1-y2)^2))
		xCoordinates = myCurrentLocation.getX() - myDestination.getX(); 
		yCoordinates = myCurrentLocation.getY() - myDestination.getY(); 
		var_squared = (xCoordinates*xCoordinates) + (yCoordinates*yCoordinates);
		
		return Math.sqrt(var_squared);
	}

	/* getArrivalTime method that calculates the required time to arrive to destination from current location */
	public double getArrivalTime() {
		// formula: time = distance / speed
		double distance = getCalculatedDistance(getCurrentLocation(), getDestination()); // obtain distance by calling getCalculatedDistance() method
		double arrivalTime;
				arrivalTime = (distance) / (car.getCurrentSpeed()); 
		return (int) arrivalTime; // cast as int to return an approximation of the hours required 
	}

	

}
