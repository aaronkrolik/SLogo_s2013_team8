package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Stamp Command
 * 
 * @author Jack Matteucci
 */

public class StampCommand extends TurtleCommand {

	public StampCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
	}

	public StampCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().stamp();
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new StampCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}
}
