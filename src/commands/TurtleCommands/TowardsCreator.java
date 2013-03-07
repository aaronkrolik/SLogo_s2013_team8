package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

public class TowardsCreator extends TurtleCommandCreator {

	public TowardsCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new TowardsCommand((TurtleCommandInput) input);
		return command;
	}

}
