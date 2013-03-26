package model;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import RDParser.Node;
import RDParser.RDParser;
import RDParser.RDParserSLogo;

import commands.Command;
import util.ColorController;
import util.Parser;
import util.ShapeController;
import view.Canvas;
import view.SlogoGUI;

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
	//private Parser myParser;
	private Parser myParser;
	private List<Command> myCommandList;
	private ColorController myColorController;
	private ShapeController myShapeController;
	private Canvas myCanvas; 

	/**
	 * Create a game of the given size with the given display for its shapes.
	 */
	public SlogoModel() {
		myTurtle = new Turtle();
		myColorController = new ColorController();
		myShapeController = new ShapeController();
		//myParser = new Parser(myTurtle);
		myParser = new Parser(myTurtle, myColorController);
	}
	
	public void setCanvas(Canvas canvas){
		myCanvas = canvas;
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
		int ret = 0;
		Dimension bounds = Canvas.CANVAS_SIZE;
		myTestLine = new Scanner(str);
        myCommandList = myParser.executeCommandLine(myTestLine);
        for(Command c : myCommandList){
        	ret = c.execute();
        }
        
	return ret;
	}
		//Node root = myParser.parse(myTestLine);
		//return root.execute().getValue();
	

}
