package Simulation;

import java.util.Scanner;

public class MakeCreator extends CommandCreator {

	public MakeCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new MakeCommand(input);
		return command;
	}

}