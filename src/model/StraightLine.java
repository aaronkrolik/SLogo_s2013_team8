package model;

import java.awt.Graphics2D;
import java.awt.Color;

import util.Location;

public class StraightLine {
	private Location myStart;
	private Location myEnd;

	public StraightLine(Location start, Location finish) {
		myStart= new Location(start.getX(), start.getY());
		myEnd = new Location(finish.getX(), finish.getY());
	}
	public void paint (Graphics2D pen) {
		pen.setColor(Color.BLUE);
        pen.drawLine((int)myStart.getX(), (int)myStart.getY(), (int)myEnd.getX(), (int)myEnd.getY());
    }

}
