package commands;

import java.util.Scanner;

public class ForwardCreator extends CommandCreator {

	public ForwardCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new ForwardCommand(input);
		return command;
	}

}
