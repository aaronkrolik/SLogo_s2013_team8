package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class RightCreator extends TurtleCommandCreator {

	public RightCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new RightCommand((TurtleCommandInput) input);
		return command;
	}

}
