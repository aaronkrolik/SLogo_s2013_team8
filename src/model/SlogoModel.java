package model;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import commands.Command;
import util.Parser;
import view.Canvas;

/**
 * Houses the Turtle and Parser. Can receive scanner inputs via Controller and
 * update Turtle based on those inputs
 * 
 * @author Jack Matteucci
 * @author David Liu
 */

public class SlogoModel {

	private Turtle myTurtle;
	private Scanner myTestLine;
	private Parser myParser;
	private List<Command> myCommandList;

	/**
	 * Create a game of the given size with the given display for its shapes.
	 */
	public SlogoModel() {
		myTurtle = new Turtle();
		myParser = new Parser(myTurtle);
	}

	public Turtle getTurtle() {
		return myTurtle;
	}

	/**
	 * Draw all elements of the simulation.
	 */
	public void paint(Graphics2D pen) {
		myTurtle.paint(pen);
	}

	/**
	 * Update simulation for this moment, given the time since the last moment.
	 * @throws Exception 
	 */
	public int update(String str) throws Exception {
		Dimension bounds = Canvas.CANVAS_SIZE;
		myTestLine = new Scanner(str);
		myCommandList = myParser.executeCommandLine(myTestLine);
		int myReturn = 0;
		for (Command c : myCommandList) {
			myReturn = c.execute();
		}
		return myReturn;
	}
}
