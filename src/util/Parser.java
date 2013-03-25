package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.Exceptions.ExpectedInput;
import util.Exceptions.MisMatchedBrackets;

import commands.AndCommand;
import commands.Command;
import commands.CommandInput;
import commands.DifferenceCommand;
import commands.EqualCommand;
import commands.GreaterCommand;
import commands.IfCommand;
import commands.IfElseCommand;
import commands.LessCommand;
import commands.MinusCommand;
import commands.NotCommand;
import commands.NotEqualCommand;
import commands.OrCommand;
import commands.ProductCommand;
import commands.QuotientCommand;
import commands.RemainderCommand;
import commands.RepeatCommand;
import commands.SumCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.ToCommand;
import commands.TurtleCommands.BackwardCommand;
import commands.TurtleCommands.ClearCommand;
import commands.TurtleCommands.ForwardCommand;
import commands.TurtleCommands.GOTOCommand;
import commands.TurtleCommands.HeadingCommand;
import commands.TurtleCommands.HideTurtleCommand;
import commands.TurtleCommands.HomeCommand;
import commands.TurtleCommands.LeftCommand;
import commands.TurtleCommands.PenDownPCommand;
import commands.TurtleCommands.RightCommand;
import commands.TurtleCommands.SetHeadingCommand;
import commands.TurtleCommands.ShowTurtleCommand;
import commands.TurtleCommands.ShowingCommand;
import commands.TurtleCommands.TowardsCommand;
import commands.TurtleCommands.XCorCommand;
import commands.TurtleCommands.YCorCommand;

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
		Command and = new AndCommand();
		Command diff = new DifferenceCommand();
		Command equal = new EqualCommand();

		Command minus = new MinusCommand();
		Command not = new NotCommand();
		Command notE = new NotEqualCommand();
		Command or = new OrCommand();
		Command product = new ProductCommand();
		Command quotient = new QuotientCommand();
		Command mod = new RemainderCommand();

		Command ifcommand = new IfCommand();
		Command ifelse = new IfElseCommand();
		Command clear = new ClearCommand();
		Command home = new HomeCommand();
		Command go = new GOTOCommand();
		Command heading = new HeadingCommand();

		Command hide = new HideTurtleCommand();
		Command show = new ShowTurtleCommand();
		Command showing = new ShowingCommand();
		Command pendown = new NotEqualCommand();
		Command penup = new OrCommand();
		Command penstatus = new PenDownPCommand();
		Command xcor = new XCorCommand();
		Command ycor = new YCorCommand();
		Command less = new LessCommand();
		Command greater = new GreaterCommand();

		myCommandMap.put("IF", ifcommand);
		myCommandMap.put("IFELSE", ifelse);
		myCommandMap.put("SETXY", go);
		myCommandMap.put("GOTO", go);
		myCommandMap.put("PENDOWN", pendown);
		myCommandMap.put("PD", pendown);
		myCommandMap.put("PENUP", penup);
		myCommandMap.put("PU", penup);
		myCommandMap.put("HIDETURTLE", hide);
		myCommandMap.put("HT", hide);
		myCommandMap.put("SHOWTURTLE", show);
		myCommandMap.put("ST", show);
		myCommandMap.put("HOME", home);
		myCommandMap.put("CLEARSCREEN", clear);
		myCommandMap.put("CS", clear);
		myCommandMap.put("HEADING", heading);
		myCommandMap.put("XCOR", xcor);
		myCommandMap.put("YCOR", ycor);
		myCommandMap.put("PENDOWN?", pendown);
		myCommandMap.put("PENDOWNP", pendown);
		myCommandMap.put("SHOWING?", showing);
		myCommandMap.put("SHOWINGP", showing);
		myCommandMap.put("YCOR", ycor);

		myCommandMap.put("MINUS", minus);
		myCommandMap.put("~", minus);
		myCommandMap.put("NOT", not);
		myCommandMap.put("NOTEQUAL?", notE);
		myCommandMap.put("NOTEQUALP", notE);
		myCommandMap.put("OR", or);
		myCommandMap.put("PRODUCT", product);
		myCommandMap.put("*", product);
		myCommandMap.put("QUOTIENT", quotient);
		myCommandMap.put("/", quotient);
		myCommandMap.put("REMAINDER", mod);
		myCommandMap.put("%", mod);

		myCommandMap.put("GREATER?", greater);
		myCommandMap.put("GREATERP", greater);
		myCommandMap.put("LESS?", less);
		myCommandMap.put("LESSP", less);
		myCommandMap.put("EQUAL?", equal);
		myCommandMap.put("EQUALP", equal);
		myCommandMap.put("DIFFERENCE", diff);
		myCommandMap.put("-", diff);
		myCommandMap.put("AND", and);
		myCommandMap.put("FORWARD", forward);
		myCommandMap.put("BACK", back);
		myCommandMap.put("REPEAT", repeat);
		myCommandMap.put("MAKE", make);
		myCommandMap.put("SUM", sum);
		myCommandMap.put("LEFT", left);
		myCommandMap.put("RIGHT", right);
		myCommandMap.put("LT", left);
		myCommandMap.put("RT", right);
		myCommandMap.put("TO", to);
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
	public List<Command> executeCommandLine(Scanner line) throws Exception {
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
	public Command getNextCommand(Scanner line) throws ExpectedInput {
		if (line.hasNext()) {
			String type = line.next();
			System.out.println(type);
			if (myCommandMap.containsKey(type)) {
				System.out.println("Here");
				Command command = (Command) myCommandMap.get(type);
				return command.createCommand(this, line);
			}
			System.out.println(type);
		}
		throw new ExpectedInput("Expected Command");
	}
	
	public Command getNextCommand(String type, Scanner line) throws ExpectedInput {
		if (line.hasNext()) {
			System.out.println(type);
			if (myCommandMap.containsKey(type)) {
				System.out.println("Here");
				Command command = (Command) myCommandMap.get(type);
				return command.createCommand(this, line);
			}
			System.out.println(type);
		}
		throw new ExpectedInput("Expected Command");
	}

	/**
	 * a Parsing method to return a list of Commands from a Scanner
	 * 
	 * @throws ExpectedInput
	 */
	public CommandSequence getNextCommandList(Scanner line)
			throws ExpectedInput {
		CommandSequence sequence = new CommandSequence();
		List<Command> commands = new ArrayList<Command>();
		if (line.hasNext(FORWARD_BRACKET)) {
			tallyBrackets(line);
			line.next();
			while (!line.hasNext(BACK_BRACKET)) {
				commands.add(getNextCommand(line));
			}
			sequence.setCommandList(commands);
			tallyBrackets(line);
			line.next();
			return sequence;
		}
		throw new ExpectedInput("expectd Command List");
	}
	
	

	/**
	 * a Parsing method to return the next String from a Scanner
	 */
	public String getNextString(Scanner line) throws ExpectedInput {
		if (line.hasNext()) {
			return line.next();
		} else {
			throw new ExpectedInput("Expected String");
		}
	}

	/**
	 * a Parsing method to return the next list of Stings from a Scanner
	 */

	public StringSequence getNextStringList(Scanner line) throws ExpectedInput {
		StringSequence sequence = new StringSequence();
		List<String> strings = new ArrayList<String>();
		if (line.hasNext(FORWARD_BRACKET)) {
			tallyBrackets(line);
			line.next();
			while (!line.hasNext(BACK_BRACKET)) {
				strings.add(line.next());
			}
			tallyBrackets(line);
			line.next();
			sequence.setStingList(strings);
			return sequence;
		}
		throw new ExpectedInput("expectd String List");
	}

	/**
	 * a Parsing method to return the next Bundled Integer from a Scanner
	 */

	public BundledInteger getNextBundledInt(Scanner line) throws ExpectedInput {
		while (line.hasNext(FORWARD_BRACKET)) {
			tallyBrackets(line);
			line.next();
		}
		if (line.hasNextInt()) {
			return new BundledInteger(line.nextInt());
		}
		String var = line.next();
		if (myCommandMap.containsKey(var)) {
			return new BundledInteger(getNextCommand(var, line));
		}
		if (!myVariableMap.containsKey(var)){
			myVariableMap.put(":" + var, 0);
		}
		return new BundledInteger(var, myVariableMap);
	}

	/**
	 * a Parsing method to return the next list of Bundled Integers from a
	 * Scanner
	 */

	public BundledIntegerSequence getNextBundledIntList(Scanner line)
			throws ExpectedInput {
		BundledIntegerSequence sequence = new BundledIntegerSequence();
		List<BundledInteger> ints = new ArrayList<BundledInteger>();
		if (line.hasNext(FORWARD_BRACKET)) {
			tallyBrackets(line);
			line.next();
			while (!line.hasNext(BACK_BRACKET)) {
				ints.add(getNextBundledInt(line));
			}
			tallyBrackets(line);
			line.next();
			sequence.setBundledIntegerList(ints);
			return sequence;
		}
		throw new ExpectedInput("expectd Int List");
	}

	private String putVariable(Scanner line) throws ExpectedInput {
		String var = getNextString(line);
		if (var.charAt(0) == VARIABLE_TAG.charAt(0)) {
			if (!myVariableMap.containsKey(var)) {
				myVariableMap.put(var, 0);
			}
			return var;
		}
		throw new ExpectedInput("Expected a Variable");
	}

	private boolean HasCommand(Scanner line) {
		for (String s : myCommandMap.keySet()) {
			if (line.hasNext(s)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean HasVariable(Scanner line) {
		for (String s : myVariableMap.keySet()) {
			if (line.hasNext(s)) {
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

	private void checkBrackets() throws MisMatchedBrackets {
		if (BracketCount != 0)
			throw new MisMatchedBrackets("MisMatched Brackets!");
	}

}
