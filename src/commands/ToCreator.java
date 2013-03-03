package commands;

import java.util.Scanner;

import model.SlogoModel;

public class ToCreator extends CommandCreator {

	public ToCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new ToCommand(input);
		return command;
	}
	@Override
	public CommandInput createCommandInput(SlogoModel model, Scanner line){
		CommandInput input = new CommandInput(model, line);
		return input;
	}

}