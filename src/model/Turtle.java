package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Vector;

import util.Location;
import util.Pixmap;
import view.Canvas;

/**
 * Turtle that manages all of the TurtleActioners with methods that control
 * movement and other inquiries
 * 
 * @author Jack Matteucci
 */

public class Turtle {

	private static final Pixmap myPicture = new Pixmap("Turtle.jpg");
	private static final int INITIAL_DIRECTION = 270;
	private static final int WIDTH_OF_TURTLE_ICON = 50;
	private static final int HEIGHT_OF_TURTLE_ICON = 50;
	private static final Dimension SIZE = new Dimension(WIDTH_OF_TURTLE_ICON,
			HEIGHT_OF_TURTLE_ICON);
	private static final Location TOP_LEFT = new Location(0, 0);
	private static final Location TOP_RIGHT = new Location(Canvas.CANVAS_WIDTH,
			0);
	private static final Location BOTTOM_LEFT = new Location(0,
			Canvas.CANVAS_HEIGHT);
	private static final Location BOTTOM_RIGHT = new Location(
			Canvas.CANVAS_WIDTH, Canvas.CANVAS_HEIGHT);
	private static final double MAX_X = BOTTOM_RIGHT.getX();
	private static final double MAX_Y = BOTTOM_RIGHT.getY();
	private static final double MIN_X = 0;
	private static final double MIN_Y = 0;
	private Map<Integer, Color> myColorMap;

	private Map<Integer, TurtleActioner> myTurtleActioners;
	
	private List<Integer> myTurtleIndex;
	private List<Integer> myStoredTurtleIndex;

	public Turtle() {
		myTurtleActioners = new HashMap<Integer, TurtleActioner>();
		myTurtleIndex = new ArrayList<Integer>();
		myTurtleIndex.add(0);
		myTurtleActioners.put(myTurtleIndex.get(0), new TurtleActioner());
	}

	/**
	 * Sets the Center of the Selected TurtleActioner
	 */

	public Integer setCenter(double x, double y) {
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).setCenter(x, y);
		}
		return returnvalue;
	}

	/**
	 * Sets the Center of the Selected TurtleActioner
	 */
	public void setCenter(Location newCenter) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).setCenter(newCenter);
		}
	}

	/**
	 * Lifts Up the Pen of the Selected TurtleActioner
	 */
	public void liftUpPen() {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).liftUpPen();
		}
	}

	/**
	 * Returns the location of the Selected TurtleActioner
	 */
	public List<Location> currentLocation() {
		List<Location> locations = new ArrayList<Location>();
		for(Integer index: myTurtleIndex){
			locations.add(myTurtleActioners.get(index).myCenter);
		}
		return locations;
	}

	/**
	 * Puts down the pen of the Selected TurtleActioner
	 */
	public void putDownPen() {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).putDownPen();
		}
	}

	/**
	 * Returns Status of the pen of the Selected TurtleActioner
	 */
	public boolean IsPenDown() {
		boolean returnvalue = false;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).IsPenDown();
		}
		return returnvalue;
	}
	
	
	public boolean getVisibility(){
		boolean returnvalue = false;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).getVisibility();
		}
		return returnvalue;
	}
	
	public Integer home(){
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).home();
		}
		return returnvalue;
	}
	
	public Integer clear(){
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).clear();
		}
		return returnvalue;
	}

	/**
	 * Changes the visibility of the Selected TurtleActioner
	 */
	public void makeVisible() {
		for(Integer index: myTurtleIndex){
			 myTurtleActioners.get(index).makeVisible();
		}
	}
	
	public void makeInvisible() {
		for(Integer index: myTurtleIndex){
			 myTurtleActioners.get(index).makeInvisible();
		}
	}

	public Integer xcor(){
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).xcor();
		}
		return returnvalue;
	}
	
	public Integer ycor(){
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).ycor();
		}
		return returnvalue;
	}
	
	public Integer heading(){
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).heading();
		}
		return returnvalue;
	}

	/**
	 * Moves the Selected TurtleActioner forward
	 */
	public void forward(double pixels) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).forward(pixels);
		}
	}

	/**
	 * Turns the Selected TurtleActioner right by certain angle
	 */
	public void right(double angle) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).right(angle);
		}
	}

	/**
	 * Turns the Selected TurtleActioner left by certain angle
	 */
	public void left(double angle) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).left(angle);
		}
	}

	/**
	 * Moves the Selected TurtleActioner backward
	 */
	public void backward(double pixels) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).backward(pixels);
		}
	}

	/**
	 * Sets the Selected TurtleActioner heading in a certain direction
	 */
	public Integer setheading(Integer direction) {
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).setheading(direction);
		}
		return returnvalue;
	}

	/**
	 * Sets the Selected TurtleActioner toward a certain coordinate
	 */
	public Integer towards(double x, double y) {
		Integer returnvalue = 0;
		for(Integer index: myTurtleIndex){
			returnvalue = myTurtleActioners.get(index).towards(x, y) ;
		}
		return returnvalue;
	}

	/**
	 * Display this shape on the screen.
	 */
	public void paint(Graphics2D pen) {
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).paint(pen);
		}
	}
	
	private Integer tellmapper(Integer id, Collection<Integer> turtleindexes) {
			if(!myTurtleActioners.containsKey(id)){
				myTurtleActioners.put(id, new TurtleActioner());
			}
			turtleindexes.add(id);
		return id;
	}
	
	public Integer tell(Collection<Integer> ids) {
		myTurtleIndex.clear();
		Integer returnvalue = 0;
		for(Integer id : ids){
			returnvalue = tellmapper(id, myTurtleIndex);
		}
		return returnvalue;
	}
	
	public Integer tellodd() {
		myTurtleIndex.clear();
		Integer returnvalue = 0;
		for(Integer id : IdCollection()){
			if(id%2 == 1){
				returnvalue = tellmapper(id,myTurtleIndex);
			}
		}
		return returnvalue;
	}
	
	public Integer telleven() {
		myTurtleIndex.clear();
		Integer returnvalue = 0;
		for(Integer id : IdCollection()){
			if(id%2 == 0){
				returnvalue = tellmapper(id, myTurtleIndex);
		}
		}
		return returnvalue;
	}
	
	public void temperarytell(Collection<Integer> ids) {
		myStoredTurtleIndex.clear();
		for(Integer id : myTurtleIndex){
			tellmapper(id, myStoredTurtleIndex);
		}
		for(Integer id : ids){
			tellmapper(id, myTurtleIndex);
		}
	}
	
	/**
	 * Convenience method
	 */
	public void temperarytell(Integer id) {
		myStoredTurtleIndex.clear();
		for(Integer i : myTurtleIndex){
			tellmapper(i, myStoredTurtleIndex);
		}
			tellmapper(id, myTurtleIndex);
	}
	
	public Collection<Integer> IdCollection() {
		return myTurtleActioners.keySet();
	}
	
	public void setprevioustell() {
		myTurtleIndex.clear();
		for(Integer id : myStoredTurtleIndex){
			tellmapper(id, myTurtleIndex);
		}
	}
	
	public void stamp(){
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).stamp();
		}
	}
	public void clearstamps(){
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).clearstamps();
		}
	}
	
	public void setpencolor(Color color){
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).setpencolor(color);
		}
	}
	
	public void setpensize(int size){
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).setpensize(size);
		}
	}
	
	public void setshape(Shape shape){
		for(Integer index: myTurtleIndex){
			myTurtleActioners.get(index).setshape(shape);
		}
	}

	private class TurtleActioner {

		private Location myCenter;
		private Location myLastCenter;
		private Location myOriginalCenter;
		private List<Location> myStamps;

		private Dimension mySize;
		private Pixmap myView;
		private Rectangle myBounds;
		private double myDirection;
		private boolean myPenStatus;
		private boolean myVisibilityStatus;
		private List<StraightLine> myLines;
		private int initialX = (Canvas.CANVAS_WIDTH ) / 2;
		private int initialY = (Canvas.CANVAS_HEIGHT) / 2;
		private int myPenSize;
		private Color myPenColor;
		private Shape myShape;

		private TurtleActioner() {
			myLines = new ArrayList<StraightLine>();
			myStamps = new ArrayList<Location>();
			myDirection = INITIAL_DIRECTION;
			myCenter = new Location(initialX, initialY);
			myView = myPicture;
			mySize = SIZE;
			myPenStatus = true;
			myVisibilityStatus = true;
			myPenSize = 1;
			myPenColor = Color.BLACK;
		}

		/**
		 * Returns rectangle that encloses this shape.
		 */

		/**
		 * Resets shape's center.
		 */
		private Integer setCenter(double x, double y) {
			ConvertInputCoor(x,y);
			Location newCenter = new Location(x,y);
			Integer distance = (int) newCenter.distance(myCenter);
			myCenter = newCenter;
			return distance;
		}
		
		private void ConvertInputCoor(double x, double y){
			x = (int) (x + (Canvas.CANVAS_WIDTH ) / 2); 
			y = (int) (x + (Canvas.CANVAS_HEIGHT ) / 2); 
		}
		
		private void ConvertOutgoingCoor(double x, double y){
			x = (int) (x - (Canvas.CANVAS_WIDTH ) / 2); 
			y = (int) (x - (Canvas.CANVAS_HEIGHT ) / 2); 
		}

		private void setCenter(Location newCenter) {
			myCenter = newCenter;
		}

		private void liftUpPen() {
			myPenStatus = false;
		}

		private Location currentLocation() {
			return myCenter;
		}

		private void putDownPen() {
			myPenStatus = true;
		}

		private boolean IsPenDown() {
			return myPenStatus;
		}

		private void makeVisible() {
			myVisibilityStatus = true;
		}
		
		private void makeInvisible() {
			myVisibilityStatus = false;
		}
		
		private boolean getVisibility(){
			return myVisibilityStatus;
		}
		
		private Integer home(){
			return setCenter(initialX, initialY);
		}
		
		private Integer clear(){
			myLines.clear();
			return home();
		}

		private void forward(double pixels) {
			WrapAroundMovement(pixels, myDirection);
		}

		private void right(double angle) {
			myDirection = turn(myDirection, angle);
		}

		private void left(double angle) {
			myDirection = turn(myDirection, -angle);
		}

		private void backward(double pixels) {
			WrapAroundMovement(pixels, turn(myDirection, 180));
		}

		private Integer setheading(Integer direction) {
			Integer angle = (int) (direction - myDirection);
			myDirection = direction;
			return angle;
		}

		private Integer towards(double x, double y) {
			return setheading((int) myCenter.difference(new Location(x, y))
					.getDirection());
		}
		
		private Integer xcor(){
			int xcor = (int) myCenter.getX();
			ConvertOutgoingCoor(xcor, 0);
			return (int) xcor;
		}
		
		private Integer ycor(){
			int ycor = (int) myCenter.getY();
			ConvertOutgoingCoor(0, ycor);
			return (int) ycor;
		}
		
		private Integer heading(){
			return (int) myDirection;
		}
		
		private void stamp(){
			myStamps.add(new Location(myCenter.getX(), myCenter.getY()));
		}
		private void clearstamps(){
			myStamps.clear();
		}
		
		private void setpencolor(Color color){
			myPenColor = color;
		}
		
		private void setpensize(int pixels){
			myPenSize = pixels;
		}
		
		private void setshape(Shape shape){
			myShape = shape;
		}

		/**
		 * Display this shape on the screen.
		 */
		private void paint(Graphics2D pen) {
			if (myVisibilityStatus) {
				myView.paint(pen, myCenter, mySize, myDirection);
			}

			for (StraightLine l : myLines) {
				l.paint(pen);
			}
			for (Location l : myStamps) {
				myView.paint(pen, l, mySize, myDirection);
			}
		}


		private void makeLine() {
			if (myPenStatus) {
				myLines.add(new StraightLine(myLastCenter, myCenter, myPenColor, myPenSize));
			}
		}

		private void updateLastCenter() {
			myLastCenter = new Location(myCenter.getX(), myCenter.getY());
		}

		public void resetCenter() {
			myCenter = new Location(myOriginalCenter.getX(),
					myOriginalCenter.getY());
		}

		private Location NextEdge(double direction) {
			direction = AcceptableAngle(direction);
			Double topleftangle = AcceptableAngle(myCenter.difference(TOP_LEFT)
					.getDirection());
			Double toprightangle = AcceptableAngle(myCenter.difference(
					TOP_RIGHT).getDirection());
			Double bottomleftangle = AcceptableAngle(myCenter.difference(
					BOTTOM_LEFT).getDirection());
			Double bottomrightangle = AcceptableAngle(myCenter.difference(
					BOTTOM_RIGHT).getDirection());

			if (direction >= topleftangle && direction < toprightangle) {
				double Xcoordinate = myCenter.getX() + myCenter.getY()
						* Math.tan(Math.toRadians(direction - 270));
				return new Location(Xcoordinate, MIN_Y);
			} else if (direction < bottomrightangle
					|| direction >= toprightangle) {
				double Ycoordinate = myCenter.getY()
						+ (MAX_X - myCenter.getX())
						* Math.tan(Math.toRadians(direction));
				return new Location(MAX_X, Ycoordinate);
			} else if (direction >= bottomrightangle
					&& direction < bottomleftangle) {
				double Xcoordinate = myCenter.getX()
						- (MAX_Y - myCenter.getY())
						* Math.tan(Math.toRadians(direction - 90));
				return new Location(Xcoordinate, MAX_Y);
			} else {
				double Ycoordinate = myCenter.getY() - myCenter.getX()
						* Math.tan(Math.toRadians(direction - 180));
				return new Location(MIN_X, Ycoordinate);
			}
		}

		private Location MirrorEdge() {
			if (myCenter.getX() == MIN_X) {
				if (myCenter.getY() == 0)
					return new Location(MAX_X, MAX_Y);
				else if (myCenter.getY() == MAX_Y)
					return new Location(MAX_X, MIN_Y);
				else
					return new Location(MAX_X, myCenter.getY());
			} else if (myCenter.getX() == MAX_X) {
				if (myCenter.getY() == 0)
					return new Location(MAX_X, MIN_Y);
				else if (myCenter.getY() == MAX_Y)
					return new Location(MIN_X, MIN_Y);
				else
					return new Location(0, myCenter.getY());
			} else if (myCenter.getY() == MIN_Y)
				return new Location(myCenter.getX(), MAX_Y);
			else if (myCenter.getY() == MAX_Y)
				return new Location(myCenter.getX(), MIN_Y);
			else
				return new Location(myCenter.getX(), myCenter.getY());
		}

		private void WrapAroundMovement(double pixels, double direction) {
			while (pixels > myCenter.distance(NextEdge(direction))) {
				updateLastCenter();
				myCenter = NextEdge(direction);
				makeLine();
				pixels -= myCenter.distance(myLastCenter);
				myCenter = MirrorEdge();
			}
			updateLastCenter();
			myCenter.translate(new Vector(direction, pixels));
			makeLine();
		}

		private double turn(double Angle, double turnAngle) {
			double angle = AcceptableAngle(Angle + turnAngle);
			return angle;
		}

		private double AcceptableAngle(double Angle) {
			while (Angle > 360)
				Angle -= 360;
			while (Angle < 0)
				Angle += 360;
			return Angle;
		}

	}



}
