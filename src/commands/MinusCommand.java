package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Minus Command
 * 
 * @author Jack Matteucci
 */
public class MinusCommand extends Command {
	private BundledInteger myFirst;

	public MinusCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
	}

	public MinusCommand() {
	}

	@Override
	public Integer execute() {
		return myFirst.getInteger() * -1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new MinusCommand(super.createCommandInput(parser, line));
	}
}
