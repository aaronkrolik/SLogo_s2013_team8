package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Greater Command
 * 
 * @author Jack Matteucci
 */
public class GreaterCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public GreaterCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public GreaterCommand() {
	}

	@Override
	public Integer execute() {
		return (myFirst.getInteger() > mySecond.getInteger()) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new GreaterCommand(super.createCommandInput(parser, line));
	}
}
