package Homework1.Part4;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* Car class*/
public class Car {
	
	// variables
	private static double speed;
	private GPS gps;
	
	/* Constructor for car class that sets speed*/
	public Car() {
		setCurrentSpeed(speed);
	}

	/* setGPS method that is used to set myGPS variable of GPS class */
	public void setGPS(GPS myGPS) {
		this.gps = myGPS;
	}
	
	/* getGPS method to return gps */
	public GPS getGPS() {
		return gps;
	}

	/* setCurrentSpeed method to set a custom speed variable */
	public void setCurrentSpeed(double currentSpeed) {
		speed = currentSpeed;
	}
	
	/* getCurrentSpeed method to return a double variable of the speed */
	public double getCurrentSpeed() {
		return speed;
	}

}
