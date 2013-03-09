
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
public class IfElseCommand extends Command {
	private BundledInteger myFirst;
	private List<Command> myFirstCommandList;
	private List<Command> mySecondCommandList;

	public IfElseCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
		myFirstCommandList = input.getCommandSequence().getCommandList();
		mySecondCommandList = input.getCommandSequence().getCommandList();
	}

	public IfElseCommand() {
	}

	@Override
	public Integer execute() {
		Integer myReturn = 0;
		if(myFirst.getInteger()!=0){
			for (Command c : myFirstCommandList) {
				myReturn = c.execute();
			}
			return myReturn;
		}
		else{
			for (Command c : mySecondCommandList) {
				myReturn = c.execute();
			}
			return myReturn;
		}
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new IfCommand(super.createCommandInput(parser, line));
	}
}
