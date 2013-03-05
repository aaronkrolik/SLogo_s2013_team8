package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class TowardsCreator extends TurtleCommandCreator {

	public TowardsCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new SetHeadingCommand((TurtleCommandInput) input);
		return command;
	}

}
