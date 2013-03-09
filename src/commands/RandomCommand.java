
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import java.util.Random;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class RandomCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public RandomCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
	}

	public RandomCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());
		return myFirst.getInteger() * (int) Math.random();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RepeatCommand(super.createCommandInput(parser, line));
	}
}
