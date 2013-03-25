package model;

import java.awt.Graphics2D;
import java.awt.Color;

import util.Location;

/**
 * Straight Line that is created by the Turtle
 * 
 * @author Jack Matteucci
 */

public class StraightLine {
	private Location myStart;
	private Location myEnd;
	private Color myColor;
	private int mySize;

	public StraightLine(Location start, Location finish, Color color, int size) {
		myStart = new Location(start.getX(), start.getY());
		myEnd = new Location(finish.getX(), finish.getY());
		myColor = color;
		mySize = size;
	}

	public void paint(Graphics2D pen) {
		pen.setColor(myColor);
		pen.drawLine((int) myStart.getX(), (int) myStart.getY(),
				(int) myEnd.getX(), (int) myEnd.getY());
	}

}
