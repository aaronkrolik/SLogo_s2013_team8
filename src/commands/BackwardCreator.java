package commands;

import java.util.Scanner;

public class BackwardCreator extends CommandCreator {

	public BackwardCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new BackwardCommand(input);
		return command;
	}

}
