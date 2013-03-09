

package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The And Command
 * 
 * @author Jack Matteucci
 */
public class AndCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public AndCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public AndCommand() {
	}

	@Override
	public Integer execute() {
		return ((myFirst.getInteger() != 0) && ( mySecond.getInteger()!=0) ) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new AndCommand(super.createCommandInput(parser, line));
	}
}
