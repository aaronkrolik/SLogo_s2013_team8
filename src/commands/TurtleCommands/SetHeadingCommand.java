package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * SetHeading Command
 * 
 * @author Jack Matteucci
 */

public class SetHeadingCommand extends TurtleCommand {
	private BundledInteger myAngle;

	public SetHeadingCommand() {
	}

	public SetHeadingCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		myAngle = input.getBundledInt();
	}

	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		return super.getTurtle().setheading(angle);
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new SetHeadingCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}