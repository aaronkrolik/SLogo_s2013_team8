package commands.MapCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class MakeCreator extends MapCommandCreator {

	public MakeCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new MakeCommand((MapCommandInput) input);
		return command;
	}

}