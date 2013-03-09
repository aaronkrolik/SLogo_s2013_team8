
package commands;

import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Product Command
 * 
 * @author Jack Matteucci
 */
public class ProductCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;

	public ProductCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}

	public ProductCommand() {
	}

	@Override
	public Integer execute() {
		return myFirst.getInteger() * mySecond.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new ProductCommand(super.createCommandInput(parser, line));
	}
}
