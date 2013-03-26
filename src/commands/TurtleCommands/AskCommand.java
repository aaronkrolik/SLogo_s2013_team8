package commands.TurtleCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Ask Command
 * 
 * @author Jack Matteucci
 */

public class AskCommand extends TurtleCommand {

	List<BundledInteger> myids;
	List<Command> myCommands;

	public AskCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		List<BundledInteger> myids = input.getBundledIntList();
		List<Command> myCommands = input.getCommandList();
	}

	public AskCommand() {
	}

	@Override
	public Integer execute() {
		List<Integer> ids = new ArrayList<Integer>();
		for (BundledInteger i : myids) {
			ids.add(i.getInteger());
		}
		Integer myReturn = 0;
		super.getTurtle().temperarytell(ids);
		for (Command c : myCommands) {
			myReturn = c.execute();
		}
		super.getTurtle().setprevioustell();
		return myReturn;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new AskCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}
}
