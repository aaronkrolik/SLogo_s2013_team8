package commands.ColorCommands;

import java.util.Scanner;

import commands.CommandInput;
import model.Turtle;
import util.ColorController;
import util.ColorInterface;
import util.ParsingInterface;
import util.TurtleInterface;
import view.Canvas;

/**
 * SubClass of Command Input that provides commands with Turtle
 * 
 * @author Jack Matteucci
 */
public class ColorCommandInput extends CommandInput {
	private ColorController myColors;
	private Canvas myCanvas;

	public ColorCommandInput(ColorInterface parser, Scanner line) {
		super(parser, line);
		myColors = parser.getColors();
	}

	public ColorController getColors() {
		return myColors;
	}
	
	public Canvas getCanvas() {
		return myCanvas;
	}

}
