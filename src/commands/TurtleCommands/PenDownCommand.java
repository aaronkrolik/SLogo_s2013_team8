package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * PenDown Command
 * 
 * @author Jack Matteucci
 */

public class PenDownCommand extends TurtleCommand {

	public PenDownCommand(TurtleCommandInput input) {
		super(input);
	}

	public PenDownCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().putDownPen();
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new PenDownCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}