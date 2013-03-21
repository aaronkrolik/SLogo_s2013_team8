package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Backward Command
 * 
 * @author Jack Matteucci
 */

public class BackwardCommand extends TurtleCommand {
	private BundledInteger myDistance;

	public BackwardCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		myDistance = input.getBundledInt();
	}

	public BackwardCommand() {
	}

	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		super.getTurtle().backward(distance);
		System.out.println(myDistance);
		return distance;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new BackwardCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
