
package commands;

import java.util.List;
import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Sum Command
 * 
 * @author Jack Matteucci
 */
public class IfCommand extends Command {
	private BundledInteger myFirst;
	private List<Command> myCommandList;

	public IfCommand(CommandInput input) {
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
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new IfCommand(super.createCommandInput(parser, line));
	}
}
