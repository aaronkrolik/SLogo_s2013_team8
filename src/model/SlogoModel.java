package model;

import java.awt.Dimension;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import commands.BackwardCreator;
import commands.Command;
import commands.CommandCreator;
import commands.ForwardCreator;
import commands.MakeCreator;
import commands.RepeatCreator;
import commands.SumCreator;
import commands.ToCreator;
import commands.VariableInput;
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
    private List<StraightLine> myLines;
	private Map<String, CommandCreator> myCommandMap;
	private Map<String, Integer> myVariableMap;
	private Map<String, VariableInput> myToMap;
	private Turtle myTurtle;
	private Scanner myTestLine;
	private Parser myParser;
	private List<Command> myCommandList;
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public SlogoModel () {
    	
		myCommandMap = new HashMap<String, CommandCreator>();
		myVariableMap = new HashMap<String, Integer>();
		myToMap = new HashMap<String,VariableInput>();
		myLines = new ArrayList<StraightLine>();
		/*
		 * Maybe a better way?? 
		 * Make a Factory file?
		 */
		CommandCreator forward = new ForwardCreator();
		myCommandMap.put("Forward",forward);
		CommandCreator repeat = new RepeatCreator();
		myCommandMap.put("Repeat",repeat);
		CommandCreator make = new MakeCreator();
		myCommandMap.put("Make",make);
		CommandCreator sum = new SumCreator();
		myCommandMap.put("Sum",sum);
		CommandCreator back = new BackwardCreator();
		myCommandMap.put("Backward",back);
		CommandCreator to = new ToCreator();
		myCommandMap.put("To", to);
		
		//myTurtle = new Turtle(canvas.getSize());
		myTurtle = new Turtle();
		myParser = new Parser(this);
    }
    
    public Map<String, CommandCreator> getCommandMap(){
    	return myCommandMap;
    }
    
    
    public Map<String, Integer> getVariableMap(){
    	return myVariableMap;
    }

    public Map<String, VariableInput> getToMap(){
    	return myToMap;
    }
    
    public Turtle getTurtle(){
    	return myTurtle;
    }
    /**
     * Draw all elements of the simulation.
     */
    public void paint(Graphics2D pen) {
    	myTurtle.paint(pen);
    	for (StraightLine l : myLines){
    		l.paint(pen);
    	}
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


