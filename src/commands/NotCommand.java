

package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class NotCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public NotCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
		
	}

	public NotCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());

		return ((myFirst.getInteger() == 0)) ? 1 : 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RepeatCommand(super.createCommandInput(parser, line));
	}
}
