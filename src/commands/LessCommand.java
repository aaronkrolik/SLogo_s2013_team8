
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Less Command
 * 
 * @author Jack Matteucci
 */
public class LessCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public LessCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public LessCommand() {
	}

	@Override
	public Integer execute() {
		return (myFirst.getInteger() < mySecond.getInteger()) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new LessCommand(super.createCommandInput(parser, line));
	}
}
