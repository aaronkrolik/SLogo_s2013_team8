package Simulation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import util.Pixmap;
import view.Canvas;


/**
 * XXX.
 * @modified by Jack Matteucci
 * @modified by Francesco Agosti
 */
public class Model {
    // bounds and input for game
    private Canvas myView;

    private static final int KEY_N = KeyEvent.VK_N;
	private static final Pixmap HERO_IMAGE = new Pixmap("Mario.png");
    private static final String TestLine = "Make Var 20 Forward :Var";
    public static final Dimension DEFAULT_SIZE = new Dimension(40, 60);
    // simulation state
    private List<StraightLine> myLines;
	private Map<String, CommandCreator> myCommandMap;
	private Map<String, Integer> myVariableMap;
	private Turtle myTurtle;
	private Scanner myTestLine;
	private Parser myParser;
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model (Canvas canvas) {
        myView = canvas;
		myCommandMap = new HashMap<String, CommandCreator>();
		myVariableMap = new HashMap<String, Integer>();
		CommandCreator forward = new ForwardCreator();
		myCommandMap.put("Forward",forward);
		CommandCreator repeat = new RepeatCreator();
		myCommandMap.put("Repeat",repeat);
		CommandCreator make = new MakeCreator();
		myCommandMap.put("Make",make);
		CommandCreator sum = new SumCreator();
		myCommandMap.put("Sum",sum);
		myTurtle = new Turtle(canvas.getSize());
		myParser = new Parser(this);
		myLines = new ArrayList<StraightLine>();
    }
    
    public Map getMap(){
    	return myCommandMap;
    }
    
    public Map getVariableMap(){
    	return myVariableMap;
    }

    public Turtle getTurtle(){
    	return myTurtle;
    }
    /**
     * Draw all elements of the simulation.
     */
    public void paint(Graphics2D pen) {
    	HERO_IMAGE.paint(pen, myTurtle.getLocation(), DEFAULT_SIZE);
    }

    /**
     * Update simulation for this moment, given the time since the last moment.
     */
    public void update (double elapsedTime) {
        Dimension bounds = myView.getSize();
        myTestLine = new Scanner(TestLine);
        if(myView.getLastKeyPressed()== KEY_N){
        	myParser.executeCommandLine(myTestLine);
        }

        }

	public Dimension getDimension(){
		return myView.getSize();
	}
	
}


