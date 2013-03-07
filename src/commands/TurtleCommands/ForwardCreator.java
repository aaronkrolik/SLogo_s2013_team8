package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class ForwardCreator extends TurtleCommandCreator {

	public ForwardCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new ForwardCommand((TurtleCommandInput) input);
		return command;
	}

}
