package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Right Command
 * 
 * @author Jack Matteucci
 */

public class RightCommand extends TurtleCommand {
	private BundledInteger myAngle;

	public RightCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		myAngle = input.getBundledInt();
	}

	public RightCommand() {
	}

	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		super.getTurtle().right(angle);
		return angle;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new RightCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}