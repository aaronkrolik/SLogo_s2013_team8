package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class SetHeadingCreator extends TurtleCommandCreator {

	public SetHeadingCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new SetHeadingCommand((TurtleCommandInput) input);
		return command;
	}

}
