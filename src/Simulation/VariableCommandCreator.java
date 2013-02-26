package Simulation;

import java.util.Scanner;

public class VariableCommandCreator extends CommandCreator {

	public VariableCommandCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new ForwardCommand(input);
		return command;
	}

}