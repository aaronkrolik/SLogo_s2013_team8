
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Qoutient Command
 * 
 * @author Jack Matteucci
 */
public class QuotientCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public QuotientCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public QuotientCommand() {
	}

	@Override
	public Integer execute() {
		return myFirst.getInteger() / mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new QuotientCommand(super.createCommandInput(parser, line));
	}
}
