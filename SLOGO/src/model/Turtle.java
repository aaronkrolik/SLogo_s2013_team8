package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.Location;
import util.Pixmap;
import util.Vector;
import view.Canvas;

public class Turtle {
	
	private static final int INITIAL_DIRECTION = 270;
	private static final Pixmap myPicture = new Pixmap("Turtle.jpg");
	private static final int WIDTH_OF_TURTLE_ICON = 50;
	private static final int HEIGHT_OF_TURTLE_ICON = 50;
	private static final Dimension SIZE = new Dimension(WIDTH_OF_TURTLE_ICON,HEIGHT_OF_TURTLE_ICON); 
	

	private Location myCenter;
    private Dimension mySize;
    private Pixmap myView;
    private Rectangle myBounds;
	private double myDirection;
	private boolean myPenStatus;
	private boolean myVisibilityStatus;
	
	
	public Turtle(){
		int initialX = (Canvas.CANVAS_WIDTH - WIDTH_OF_TURTLE_ICON)/2;
		int initialY = (Canvas.CANVAS_HEIGHT - HEIGHT_OF_TURTLE_ICON)/2;
		myDirection = INITIAL_DIRECTION;
		myCenter = new Location(initialX, initialY);		
		myView = myPicture;
		mySize = SIZE;
		resetBounds();
		myPenStatus = true;
		myVisibilityStatus = true;
	}
	
	 /**
     * Returns rectangle that encloses this shape.
     */
    private void resetBounds () {
        myBounds = new Rectangle((int)getLeft(), (int)getTop(), mySize.width, mySize.height);
    }
    
    /**
     * Resets shape's center.
     */
    public void setCenter (double x, double y) {
        myCenter.setLocation(x, y);
        resetBounds();
    }
    public void setCenter(Location newCenter){
    	myCenter = newCenter;
    	resetBounds();
    }
	
    public boolean liftUpPen(){
    	myPenStatus = false;
    	return myPenStatus;
    }
    
    public Location currentLocation(){
    	return myCenter;
    }
    
    public boolean putDownPen(){
    	myPenStatus = true;
    	return myPenStatus;
    }
	public boolean IsPenDown(){
		return myPenStatus;
	}
	public void ToggleVisibility(){
		myVisibilityStatus = !myVisibilityStatus;
	}

    public void forward(double pixels){
		myCenter.translate(new Vector(myDirection, pixels));
	}
    
    /**
     * Display this shape on the screen.
     */
    public void paint (Graphics2D pen)
    {
    	if(myVisibilityStatus){
    		 myView.paint(pen, myCenter, mySize);
    	}  
    }

    /**
     * Returns shape's left-most coordinate in pixels.
     */
    public double getLeft () {
        return myCenter.getX() - mySize.width / 2;
    }
    

    /**
     * Returns shape's top-most coordinate in pixels.
     */
    public double getTop () {
        return myCenter.getY() - mySize.height / 2;
    }
}
