package commands.ColorCommands;

import java.util.Scanner;

import util.ColorController;
import util.ColorInterface;
import util.ParsingInterface;
import util.TurtleInterface;
import commands.Command;
import commands.CommandInput;

import model.Turtle;

/**
 * SuperClass for all Commands that require access to turtle
 * 
 * @author Jack Matteucci
 */

public abstract class ColorCommand extends Command {
	private ColorController myColorController;

	public ColorCommand() {
	}

	public ColorCommand(ColorCommandInput input) {
		super(input);
		myColorController = input.getColors();
	}

	protected ColorController getColors() {
		return myColorController;
	}

	@Override
	protected CommandInput createCommandInput(ParsingInterface parser,
			Scanner line) {
		return new ColorCommandInput((ColorInterface) parser, line);
	}

}
