
package commands;

import java.util.List;
import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The If Command
 * 
 * @author Jack Matteucci
 */
public class IfCommand extends Command {
	private BundledInteger myFirst;
	private List<Command> myCommandList;

	public IfCommand(CommandInput input) throws ExpectedInput {
		super(input);
		myFirst = input.getBundledInt();
		myCommandList = input.getCommandSequence().getCommandList();
	}

	public IfCommand() {
	}

	@Override
	public Integer execute() {
		if(myFirst.getInteger()!=0){
			Integer myReturn = 0;
			for (Command c : myCommandList) {
				myReturn = c.execute();
			}
			return myReturn;
		}
		else return 0;
	}


	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new IfCommand(super.createCommandInput(parser, line));
	}
}
