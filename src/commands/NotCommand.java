package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Not Command
 * 
 * @author Jack Matteucci
 */
public class NotCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public NotCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();

	}

	public NotCommand() {
	}

	@Override
	public Integer execute() {

		return ((myFirst.getInteger() == 0)) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new NotCommand(super.createCommandInput(parser, line));
	}
}
