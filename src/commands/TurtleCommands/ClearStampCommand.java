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

public class ClearStampCommand extends TurtleCommand {

	public ClearStampCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
	}

	public ClearStampCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().clearstamps();
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new ClearStampCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
