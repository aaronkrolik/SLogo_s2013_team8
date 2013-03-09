
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class DifferenceCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public DifferenceCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public DifferenceCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());
		System.out.println(mySecond.getInteger());
		return myFirst.getInteger() - mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RepeatCommand(super.createCommandInput(parser, line));
	}
}