package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class LeftCreator extends TurtleCommandCreator {

	public LeftCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new LeftCommand((TurtleCommandInput) input);
		return command;
	}

}
