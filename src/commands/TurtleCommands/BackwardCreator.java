package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class BackwardCreator extends TurtleCommandCreator {

	public BackwardCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new BackwardCommand((TurtleCommandInput) input);
		return command;
	}

}
