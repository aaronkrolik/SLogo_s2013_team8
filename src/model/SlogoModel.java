package model;

import java.awt.Dimension;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import commands.Command;
import commands.CommandCreator;
import commands.RepeatCreator;
import commands.SumCreator;
import commands.MapCommands.MakeCreator;
import commands.MapCommands.ToCreator;
import commands.MapCommands.VariableInput;
import commands.TurtleCommands.BackwardCreator;
import commands.TurtleCommands.ForwardCreator;
import util.Parser;
import view.Canvas;




public class SlogoModel {
//    // bounds and input for game
//    private Canvas myView;
//
//    private static final int KEY_N = KeyEvent.VK_N;
//	private static final Pixmap HERO_IMAGE = new Pixmap("Mario.png");
//    private static final String TestLine = "Make Var 20 Forward :Var";
//    public static final Dimension DEFAULT_SIZE = new Dimension(40, 60);
	
	
    // simulation state
	private Turtle myTurtle;
	private Scanner myTestLine;
	private Parser myParser;
	private List<Command> myCommandList;
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public SlogoModel () {
    	
		/*
		 * Maybe a better way?? 
		 * Make a Factory file?
		 */
		//myTurtle = new Turtle(canvas.getSize());
		myTurtle = new Turtle();
		myParser = new Parser(myTurtle);
    }
    
    
    public Turtle getTurtle(){
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
     */
    public void update (String str) {
        Dimension bounds = Canvas.CANVAS_SIZE;
        myTestLine = new Scanner(str);
        myCommandList = myParser.executeCommandLine(myTestLine);
        for(Command c : myCommandList){
        	c.execute();
        }
        }
}


