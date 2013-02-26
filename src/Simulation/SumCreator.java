package Simulation;

import java.util.Scanner;

public class SumCreator extends CommandCreator {

	public SumCreator() {
	}

	@Override
	public Command createCommand(CommandInput input) {
		Command command = new SumCommand(input);
		return command;
	}

}