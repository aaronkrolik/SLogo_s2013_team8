package commands.TurtleCommands;

import java.util.Scanner;

import util.ParsingInterface;
import util.TurtleInterface;
import commands.Command;
import commands.CommandInput;

import model.Turtle;

/**
 * SuperClass for all Commands that require access to turtle
 * 
 * @author Jack Matteucci
 */

public abstract class TurtleCommand extends Command {
	private Turtle myTurtle;

	public TurtleCommand() {
	}

	public TurtleCommand(TurtleCommandInput input) {
		super(input);
		myTurtle = input.getTurtle();
	}

	protected Turtle getTurtle() {
		return myTurtle;
	}

	@Override
	protected CommandInput createCommandInput(ParsingInterface parser,
			Scanner line) {
		return new TurtleCommandInput((TurtleInterface) parser, line);
	}

}
