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
 * Backward Command
 * 
 * @author Jack Matteucci
 */

public class TellEvenCommand extends TurtleCommand {

	public TellEvenCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
	}

	public TellEvenCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().telleven();
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new TellEvenCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
