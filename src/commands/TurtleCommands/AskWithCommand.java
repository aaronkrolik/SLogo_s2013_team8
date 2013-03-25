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

public class AskWithCommand extends TurtleCommand {

	List<Command> myCommandConditions;
	Command myQuestion;
	List<Command> myCommands;
	public AskWithCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		List<Command> myCommandConditions = input.getCommandSequence().getCommandList();
		if(myCommandConditions.size()!= 2) throw new ExpectedInput();
		myQuestion = myCommandConditions.get(0);
		List<Command> myCommands = input.getCommandSequence().getCommandList();
	}

	public AskWithCommand() {
	}

	@Override
	public Integer execute() {
		List<Integer> ids = new ArrayList<Integer>();
		for(Integer id : super.getTurtle().IdCollection()){
			super.getTurtle().temperarytell(id);
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
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new AskWithCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
