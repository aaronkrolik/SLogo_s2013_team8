package commands.TurtleCommands;

import java.util.Scanner;

import commands.CommandInput;
import model.Turtle;
import util.ParsingInterface;
import util.TurtleInterface;

/**
 * SubClass of Command Input that provides commands with Turtle
 * 
 * @author Jack Matteucci
 */
public class TurtleCommandInput extends CommandInput {
	private Turtle myTurtle;

	public TurtleCommandInput(TurtleInterface parser, Scanner line) {
		super(parser, line);
		myTurtle = parser.getTurtle();
	}

	public Turtle getTurtle() {
		return myTurtle;
	}

}
