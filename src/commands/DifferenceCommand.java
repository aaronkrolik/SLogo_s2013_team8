
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class DifferenceCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public DifferenceCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public DifferenceCommand() {
	}

	@Override
	public Integer execute() {
		return myFirst.getInteger() - mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new DifferenceCommand(super.createCommandInput(parser, line));
	}
}
