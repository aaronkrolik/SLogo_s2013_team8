package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
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

	private List<TurtleActioner> myTurtleActioners;
	Integer TurtleIndex;

	public Turtle() {
		myTurtleActioners = new ArrayList<TurtleActioner>();
		myTurtleActioners.add(new TurtleActioner());
		TurtleIndex = 0;
	}

	/**
	 * Sets the Center of the Selected TurtleActioner
	 */

	public void setCenter(double x, double y) {
		myTurtleActioners.get(TurtleIndex).setCenter(x, y);
	}

	/**
	 * Sets the Center of the Selected TurtleActioner
	 */
	public void setCenter(Location newCenter) {
		myTurtleActioners.get(TurtleIndex).setCenter(newCenter);
	}

	/**
	 * Lifts Up the Pen of the Selected TurtleActioner
	 */
	public boolean liftUpPen() {
		return myTurtleActioners.get(TurtleIndex).liftUpPen();
	}

	/**
	 * Returns the location of the Selected TurtleActioner
	 */
	public Location currentLocation() {
		return myTurtleActioners.get(TurtleIndex).currentLocation();
	}

	/**
	 * Puts down the pen of the Selected TurtleActioner
	 */
	public boolean putDownPen() {
		return myTurtleActioners.get(TurtleIndex).putDownPen();
	}

	/**
	 * Returns Status of the pen of the Selected TurtleActioner
	 */
	public boolean IsPenDown() {
		return myTurtleActioners.get(TurtleIndex).IsPenDown();
	}

	/**
	 * Changes the visibility of the Selected TurtleActioner
	 */
	public void ToggleVisibility() {
		myTurtleActioners.get(TurtleIndex).ToggleVisibility();
	}
	


	/**
	 * Moves the Selected TurtleActioner forward
	 */
	public void forward(double pixels) {
		myTurtleActioners.get(TurtleIndex).forward(pixels);
	}

	/**
	 * Turns the Selected TurtleActioner right by certain angle
	 */
	public void right(double angle) {
		myTurtleActioners.get(TurtleIndex).right(angle);
	}

	/**
	 * Turns the Selected TurtleActioner left by certain angle
	 */
	public void left(double angle) {
		myTurtleActioners.get(TurtleIndex).left(angle);
	}

	/**
	 * Moves the Selected TurtleActioner backward
	 */
	public void backward(double pixels) {
		myTurtleActioners.get(TurtleIndex).backward(pixels);
	}

	/**
	 * Sets the Selected TurtleActioner heading in a certain direction
	 */
	public Integer setheading(Integer direction) {
		return myTurtleActioners.get(TurtleIndex).setheading(direction);
	}

	/**
	 * Sets the Selected TurtleActioner toward a certain coordinate
	 */
	public Integer towards(double x, double y) {
		return myTurtleActioners.get(TurtleIndex).towards(x, y);
	}

	/**
	 * Display this shape on the screen.
	 */
	public void paint(Graphics2D pen) {
		myTurtleActioners.get(TurtleIndex).paint(pen);
	}

	private class TurtleActioner {

		private Location myCenter;
		private Location myLastCenter;
		private Location myOriginalCenter;

		private Dimension mySize;
		private Pixmap myView;
		private Rectangle myBounds;
		private double myDirection;
		private boolean myPenStatus;
		private boolean myVisibilityStatus;
		private List<StraightLine> myLines;

		protected TurtleActioner() {
			myLines = new ArrayList<StraightLine>();
			int initialX = (Canvas.CANVAS_WIDTH - WIDTH_OF_TURTLE_ICON) / 2;
			int initialY = (Canvas.CANVAS_HEIGHT - HEIGHT_OF_TURTLE_ICON) / 2;
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
		private void resetBounds() {
			myBounds = new Rectangle((int) getLeft(), (int) getTop(),
					mySize.width, mySize.height);
		}

		/**
		 * Resets shape's center.
		 */
		private void setCenter(double x, double y) {
			myCenter.setLocation(x, y);
			resetBounds();
		}

		private void setCenter(Location newCenter) {
			myCenter = newCenter;
			resetBounds();
		}

		private boolean liftUpPen() {
			myPenStatus = false;
			return myPenStatus;
		}

		private Location currentLocation() {
			return myCenter;
		}

		private boolean putDownPen() {
			myPenStatus = true;
			return myPenStatus;
		}

		private boolean IsPenDown() {
			return myPenStatus;
		}

		private void ToggleVisibility() {
			myVisibilityStatus = !myVisibilityStatus;
		}
		
		private boolean getVisibility(){
			return myVisibilityStatus;
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
		}

		/**
		 * Returns shape's left-most coordinate in pixels.
		 */
		private double getLeft() {
			return myCenter.getX() - mySize.width / 2;
		}

		private void makeLine() {
			if (myPenStatus) {
				myLines.add(new StraightLine(myLastCenter, myCenter));
			}
		}

		/**
		 * Returns shape's top-most coordinate in pixels.
		 */
		private double getTop() {
			return myCenter.getY() - mySize.height / 2;
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
