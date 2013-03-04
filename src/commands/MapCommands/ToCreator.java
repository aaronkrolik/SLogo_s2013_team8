package commands.MapCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

import util.MapInterface;
import util.ParsingInterface;

import model.SlogoModel;

public class ToCreator extends MapCommandCreator {

	public ToCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new ToCommand((MapCommandInput) input);
		return command;
	}

}