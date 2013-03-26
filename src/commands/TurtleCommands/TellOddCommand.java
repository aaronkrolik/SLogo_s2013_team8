package commands.TurtleCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Tell Odd command
 * 
 * @author Jack Matteucci
 */

public class TellOddCommand extends TurtleCommand {

	public TellOddCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
	}

	public TellOddCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().tellodd();
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new TellOddCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
