package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

import java.util.Random;

/**
 * The Random Command
 * 
 * @author Jack Matteucci
 */
public class RandomCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public RandomCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
	}

	public RandomCommand() {
	}

	@Override
	public Integer execute() {
		return myFirst.getInteger() * (int) Math.random();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new RandomCommand(super.createCommandInput(parser, line));
	}
}
