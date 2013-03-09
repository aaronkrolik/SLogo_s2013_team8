
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Remainder Command
 * 
 * @author Jack Matteucci
 */
public class RemainderCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public RemainderCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
	}

	public RemainderCommand() {
	}

	@Override
	public Integer execute() {

		return myFirst.getInteger() % mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new RemainderCommand(super.createCommandInput(parser, line));
	}
}
