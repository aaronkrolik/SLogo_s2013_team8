package commands.MapCommands;

import commands.Command;
import commands.CommandInput;


public class VariableCreator extends MapCommandCreator {
	VariableInput myVariableInput;
	
	public VariableCreator(VariableInput input) {
		myVariableInput = input;
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command variablecommand = new VariableCommand((MapCommandInput) input, myVariableInput);
		
		return variablecommand;
	}

}
