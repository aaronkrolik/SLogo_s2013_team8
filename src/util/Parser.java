package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import commands.Command;
import commands.CommandInput;
import commands.RepeatCommand;
import commands.SumCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.ToCommand;
import commands.TurtleCommands.BackwardCommand;
import commands.TurtleCommands.ForwardCommand;
import commands.TurtleCommands.LeftCommand;
import commands.TurtleCommands.RightCommand;
import commands.TurtleCommands.SetHeadingCommand;
import commands.TurtleCommands.TowardsCommand;

import model.SlogoModel;
import model.Turtle;

/**
 * Contains all the Maps and methods necessary to parse the command line
 * 
 * @author Jack Matteucci
 */

public class Parser implements ParsingInterface, TurtleInterface, MapInterface {

	private Scanner myLine;
	private Turtle myTurtle;
	private List<Command> myReturn;
	private Map<String, Command> myCommandMap;
	private Map<String, Integer> myVariableMap;
	private final static String FORWARD_BRACKET = "\\[";
	private final static String BACK_BRACKET = "]";
	private final static String VARIABLE_TAG = ":";
	private int BracketCount;

	public Parser(Turtle turtle) {
		myCommandMap = new HashMap<String, Command>();
		myVariableMap = new HashMap<String, Integer>();
		/*
		 * Maybe a better way?? Make a Factory file?
		 */
		Command forward = new ForwardCommand();
		Command repeat = new RepeatCommand();
		Command make = new MakeCommand();
		Command sum = new SumCommand();
		Command back = new BackwardCommand();
		Command to = new ToCommand();
		Command right = new RightCommand();
		Command left = new LeftCommand();
		Command setheading = new SetHeadingCommand();
		Command towards = new TowardsCommand();
		myCommandMap.put("FORWARD", forward);
		myCommandMap.put("BACK", back);
		myCommandMap.put("REPEAT", repeat);
		myCommandMap.put("MAKE", make);
		myCommandMap.put("SUM", sum);
		myCommandMap.put("LEFT", left);
		myCommandMap.put("RIGTH", right);
		myCommandMap.put("T0", to);
		myCommandMap.put("FD", forward);
		myCommandMap.put("BK", back);
		myCommandMap.put("SET", make);
		myCommandMap.put("+", sum);
		myCommandMap.put("LT", left);
		myCommandMap.put("RT", right);
		myCommandMap.put("SETHEADING", setheading);
		myCommandMap.put("SETH", setheading);
		myCommandMap.put("TOWARDS", towards);
		myTurtle = turtle;
	}

	public Map<String, Command> getCommandMap() {
		return myCommandMap;
	}

	public Map<String, Integer> getVariableMap() {
		return myVariableMap;
	}

	public Turtle getTurtle() {
		return myTurtle;
	}

	/**
	 * The method that parses through a command line, to be called in Model
	 */
	public List<Command> executeCommandLine(Scanner line) {
		BracketCount = 0;
		myReturn = new ArrayList<Command>();
		while (line.hasNext()) {
			checkBrackets();
			Command command = getNextCommand(line);
			myReturn.add(command);
			while (line.hasNext(BACK_BRACKET)) {
				tallyBrackets(line);
				line.next();
			}
		}
		checkBrackets();
		System.out.println(myReturn);
		return myReturn;
	}

	/**
	 * a Parsing method to return the next command from a scanner
	 */
	public Command getNextCommand(Scanner line) {
		if (line.hasNext()) {
			String type = line.next();
			System.out.println(type);
			if (myCommandMap.containsKey(type)) {
				Command command = (Command) myCommandMap.get(type);
				return command.createCommand(this, line);
			}
		}
		return null; // BUG BUG Throw Command not found exception
	}

	/**
	 * a Parsing method to return a list of Commands from a Scanner
	 */
	public CommandSequence getNextCommandList(Scanner line) {
		CommandSequence sequence = new CommandSequence();
		if (line.hasNext()) {
			if (line.hasNext(FORWARD_BRACKET)) {
				tallyBrackets(line);
				line.next();
				while (!line.hasNext(BACK_BRACKET)) {
					sequence.getCommandList().add(getNextCommand(line));
				}
				tallyBrackets(line);
				line.next();
			}
			return sequence;
		}
		System.out.println("CommandList");
		return null;
	}

	/**
	 * a Parsing method to return the next String from a Scanner
	 */
	public String getNextString(Scanner line) {
		if (line.hasNext()) {
			return line.next();
		} else {
			return ""; // BUG BUG throw String Not found exception
		}
	}

	/**
	 * a Parsing method to return the next list of Stings from a Scanner
	 */

	public StringSequence getNextStringList(Scanner line) {
		StringSequence sequence = new StringSequence();
		List<String> strings = new ArrayList<String>();
		if (line.hasNext()) {
			if (line.hasNext(FORWARD_BRACKET)) {
				tallyBrackets(line);
				line.next();
				while (!line.hasNext(BACK_BRACKET)) {
					sequence.getStringList().add(line.next());
				}
				tallyBrackets(line);
				line.next();
			}
			return sequence;
		}
		System.out.println("CommandList");
		return null;
	}

	/**
	 * a Parsing method to return the next Bundled Integer from a Scanner
	 */

	public BundledInteger getNextBundledInt(Scanner line) {
		while (line.hasNext(FORWARD_BRACKET)) {
			tallyBrackets(line);
			line.next();
		}
		if (line.hasNextInt()) {
			return new BundledInteger(line.nextInt());
		} else {
			if (HasCommand(line)) {
				return new BundledInteger(getNextCommand(line));
			}
			String var = putVariable(line);
			return new BundledInteger(var, myVariableMap);
		}
	}

	/**
	 * a Parsing method to return the next list of Bundled Integers from a
	 * Scanner
	 */

	public BundledIntegerSequence getNextBundledIntList(Scanner line) {
		BundledIntegerSequence sequence = new BundledIntegerSequence();
		if (line.hasNext()) {
			if (line.hasNext(FORWARD_BRACKET)) {
				tallyBrackets(line);
				line.next();
				while (!line.hasNext(BACK_BRACKET)) {
					sequence.getBundledIntegerList().add(
							getNextBundledInt(line));
				}
				tallyBrackets(line);
				line.next();
			}
			return sequence;
		}
		System.out.println("CommandList");
		return null;
	}

	private String putVariable(Scanner line) {
		String var = getNextString(line);
		if (var.charAt(0) == VARIABLE_TAG.charAt(0)) {
			if (!myVariableMap.containsKey(var)) {
				myVariableMap.put(var, 0);
			}
			return var;
		}
		return null; // BUG BUG THROW EXCEPTION Variable Not found
	}

	private boolean HasCommand(Scanner line) {
		for (Object s : myCommandMap.keySet()) {
			if (line.hasNext((String) s)) {
				return true;
			}
		}
		return false;
	}

	private void tallyBrackets(Scanner line) {
		if (line.hasNext(FORWARD_BRACKET))
			BracketCount++;
		else if (line.hasNext(BACK_BRACKET))
			BracketCount--;
	}

	private void checkBrackets() {
		if (BracketCount != 0)
			System.out.println("Mismatched Brackets!"); // BUG BUG, Throw
														// Mismatched brackets
														// exception (can change
														// this method into a
														// boolean)
	}

}
