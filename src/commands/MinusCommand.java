
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class MinusCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public MinusCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
	}

	public MinusCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myFirst.getInteger());
		System.out.println(mySecond.getInteger());
		return myFirst.getInteger()*-1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RepeatCommand(super.createCommandInput(parser, line));
	}
}
