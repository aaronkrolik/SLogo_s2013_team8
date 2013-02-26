package Simulation;

import java.util.List;

public class VariableCommand extends Command {
	private List<String> myVariables;
	private List<Command> myCommands;
	
	public VariableCommand(CommandInput input) {
		super(input);
		myVariables = super.getInput().getCommandList();
		myCommands = super.getInput().getCommandList();
	}
	@Override
	public Integer execute() {
		Integer myReturn = 0;
		for(int i = 0; i<myTimes; i++){
			for(Command c: myCommandList){
				myReturn = c.execute();
			}
		}
		return myReturn;
	}
}
