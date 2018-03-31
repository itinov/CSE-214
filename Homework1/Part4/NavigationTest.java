package Homework1.Part4;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* Main testing class */
public class NavigationTest {

	/* Main method */
	public static void main(String[] args) {
		
		// create current location and destination variables of Location class with desired x and y coordinates 
		Location myCurrentLocation = new Location(354, 538);
		Location myDestination = new Location(108, 25);
		
		// create myCar variable of Car class by calling Car class constructor 
		Car myCar = new Car();
		
		/* Initializing GPS object and setting current and destination locations */
		GPS myGPS = new GPS(); // call GPS constructor
		myGPS.setCurrentLocation(myCurrentLocation);
		myGPS.setDestination(myDestination);
		myCar.setGPS(myGPS);
		
		/* Start the car and set the current speed */
		myCar.setCurrentSpeed(35.0);
		
		// see the output
		System.out.printf("Distance: " + "%.2f" + " miles.", ((GPS) myCar.getGPS()).getCalculatedDistance(myCurrentLocation, myDestination));
		System.out.println("\nArrival: " + ((GPS) myCar.getGPS()).getArrivalTime() + " hours to arrive");

	}
}
