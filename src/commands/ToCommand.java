package commands;

import java.util.List;

public class ToCommand extends Command {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;
	VariableInput myVariableInput;
	
	public ToCommand(CommandInput input) {
		super(input);	
		myName =input.getString();
		myVariableList = input.getStringList();
		myCommandList = input.getCommandList();
		myVariableInput = new VariableInput(myName, myVariableList, myCommandList);
	}
	@Override
	public Integer execute() {
		super.getInput().getModel().getToMap().put(myName, myVariableInput);
		return 1;
	}

}
