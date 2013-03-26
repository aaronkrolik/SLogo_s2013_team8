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
public class SumCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public SumCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		System.out.println(myFirst.getInteger());
		mySecond = input.getBundledInt();
	}

	public SumCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());
		System.out.println(mySecond.getInteger());
		return myFirst.getInteger() + mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new SumCommand(super.createCommandInput(parser, line));
	}
}
