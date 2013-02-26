package Simulation;

import java.awt.Dimension;

import util.Location;
import util.Vector;

public class Turtle {
	private double myDirection;
	private double myOriginalDirection;
	private boolean myPenStatus;
	private boolean myVisibilityStatus;
	private Location myLocation;
	private Location myOriginalLocation;
	private Location myPastLocation;
	
	public Turtle(Dimension bounds) {
		myOriginalLocation = new Location (bounds.getWidth()/2,bounds.getHeight()/2);
		myLocation = new Location (bounds.getWidth()/2,bounds.getHeight()/2);
		myDirection = 0;
		myOriginalDirection = 0;
		myPenStatus = true;
		myVisibilityStatus = true;
	}
	
	public void Forward(double pixels){
		myPastLocation = new Location(myLocation.getX(), myLocation.getY());
		myLocation.translate(new Vector(myDirection, pixels));
	}
	
	public void TogglePen(){
		myPenStatus = !myPenStatus;
	}
	
	public Location getLocation(){
		return myLocation;
	}
	public Location getPastLocation(){
		return myPastLocation;
	}
	
	public boolean IsPenDown(){
		return myPenStatus;
	}
	public void ToggleVisibility(){
		myVisibilityStatus = !myVisibilityStatus;
	}

}
