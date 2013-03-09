package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Forward Command
 * 
 * @author Jack Matteucci
 */

public class ForwardCommand extends TurtleCommand {
	private BundledInteger myDistance;

	public ForwardCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		myDistance = input.getBundledInt();
	}

	public ForwardCommand() {
	}

	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		super.getTurtle().forward(distance);
		return distance;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new ForwardCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
