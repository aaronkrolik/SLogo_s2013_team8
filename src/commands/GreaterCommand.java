

package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class GreaterCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public GreaterCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public GreaterCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());
		System.out.println(mySecond.getInteger());
		return (myFirst.getInteger() > mySecond.getInteger()) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RepeatCommand(super.createCommandInput(parser, line));
	}
}