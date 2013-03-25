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
 * Backward Command
 * 
 * @author Jack Matteucci
 */

public class TellCommand extends TurtleCommand {

	List<BundledInteger> myids;
	public TellCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		List<BundledInteger> myids = input.getBundledIntSequence().getBundledIntegerList();
	}

	public TellCommand() {
	}

	@Override
	public Integer execute() {
		List<Integer> ids = new ArrayList<Integer>();
		for(BundledInteger i : myids){
			ids.add(i.getInteger());
		}
		super.getTurtle().tell(ids);
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new TellCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
