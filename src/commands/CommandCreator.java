package commands;

import java.util.Scanner;

import model.SlogoModel;

public abstract class CommandCreator {


	public CommandCreator() {
	}
	
	public abstract Command createCommand(CommandInput input);
	
	public CommandInput createCommandInput(SlogoModel model, Scanner line){
		CommandInput input = new CommandInput(model, line);
		return input;
	}

}
