package commands.MapCommands;

import java.util.List;
import java.util.Scanner;

import util.ParsingInterface;

import commands.Command;
import commands.RepeatCommand;

public class ToCommand extends MapCommand {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;
	VariableInput myVariableInput;
	
	public ToCommand() {
	}
	
	public ToCommand(MapCommandInput input) {
		super(input);
		myName =input.getString();
		myVariableList = input.getStringSequence().getStringList();
		myCommandList = input.getCommandSequence().getCommandList();
		myVariableInput = new VariableInput(myName, myVariableList, myCommandList);
	}
	
	@Override
	public Integer execute() {
		Command command = new VariableCommand(myVariableInput);
		super.getCommandMap().put(myName, command);
		return 1;
	}
	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new ToCommand((MapCommandInput) super.createCommandInput(parser, line));
	}

}
