package Simulation;

import java.util.Scanner;

public class RepeatCreator extends CommandCreator {

	public RepeatCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new RepeatCommand(input);
		return command;
	}
}
