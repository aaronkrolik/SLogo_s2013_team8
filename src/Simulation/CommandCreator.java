package Simulation;

import java.util.Scanner;

public abstract class CommandCreator {


	public CommandCreator() {
	}
	
	public abstract Command createCommand(CommandInput input);
	
	public CommandInput createCommandInput(Model model, Scanner line){
		CommandInput input = new CommandInput(model, line);
		return input;
	}

}
