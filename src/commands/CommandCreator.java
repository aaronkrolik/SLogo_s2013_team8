package commands;

import java.util.Scanner;

import util.ParsingInterface;

import model.SlogoModel;

public abstract class CommandCreator {


	public CommandCreator() {
	}
	
	public abstract Command createCommand(CommandInput input);
	
	public CommandInput createCommandInput(ParsingInterface parser, Scanner line){
		CommandInput input = new CommandInput(parser, line);
		return input;
	}

}
