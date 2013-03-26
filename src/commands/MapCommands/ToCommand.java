package commands.MapCommands;

import java.util.List;
import java.util.Scanner;

import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

import commands.Command;
import commands.RepeatCommand;

/**
 * The To Command
 * 
 * @author Jack Matteucci
 */

public class ToCommand extends MapCommand {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;
	VariableInput myVariableInput;

	public ToCommand() {
	}

	public ToCommand(MapCommandInput input) throws ExpectedInput {
		super(input);
		myName = input.getString();
		super.getCommandMap().put(myName,
				new VariableCommand(new VariableInput()));
		myVariableList = input.getStringList();
		myCommandList = input.getCommandList();
		myVariableInput = new VariableInput(myName, myVariableList,
				myCommandList);
	}

	@Override
	public Integer execute() {
		Command command = new VariableCommand(myVariableInput);
		super.getCommandMap().put(myName, command);
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new ToCommand((MapCommandInput) super.createCommandInput(parser,
				line));
	}

}
