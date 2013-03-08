package commands;

import java.util.Scanner;

import util.ParsingInterface;

import model.SlogoModel;

/**
 * Command superclass that has methods execute, createCommand and
 * CreateCommandInput in order to allow for abstract manipulation of commands
 * 
 * @author Jack Matteucci
 */

public abstract class Command {
	private CommandInput myInput;

	public Command() {
	}

	public Command(CommandInput input) {
		myInput = input;
	}

	protected CommandInput getInput() {
		return myInput;
	}

	public abstract Integer execute();

	public abstract Command createCommand(ParsingInterface parser, Scanner line);

	protected CommandInput createCommandInput(ParsingInterface parser,
			Scanner line) {
		return new CommandInput(parser, line);
	}

}
