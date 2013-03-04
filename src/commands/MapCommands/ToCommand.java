package commands.MapCommands;

import java.util.List;

import commands.Command;
import commands.CommandCreator;

public class ToCommand extends MapCommand {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;
	VariableInput myVariableInput;
	
	public ToCommand(MapCommandInput input) {
		super(input);
		myName =input.getString();
		myVariableList = input.getStringList();
		myCommandList = input.getCommandList();
		myVariableInput = new VariableInput(myName, myVariableList, myCommandList);
	}
	@Override
	public Integer execute() {
		CommandCreator creator = new VariableCreator(myVariableInput);
		super.getCommandMap().put(myName, creator);
		return 1;
	}

}
