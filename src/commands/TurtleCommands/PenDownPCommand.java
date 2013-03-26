package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * PenDownP Command
 * 
 * @author Jack Matteucci
 */

public class PenDownPCommand extends TurtleCommand {

	public PenDownPCommand(TurtleCommandInput input) {
		super(input);
	}

	public PenDownPCommand() {
	}

	@Override
	public Integer execute() {
		if (super.getTurtle().IsPenDown())
			return 1;
		return 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new PenDownPCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}