package commands;

import java.util.Map;
import java.util.Scanner;

import commands.CommandInput;

import util.CanvasInterface;
import util.MapInterface;
import util.ParsingInterface;
import view.Canvas;

/**
 * SubClass of Command Input that provides commands with Maps
 * 
 * @author Jack Matteucci
 */

public class CanvasCommandInput extends CommandInput {
	private Canvas myCanvas;

	public CanvasCommandInput(CanvasInterface parser, Scanner line) {
		super(parser, line);
		myCanvas = parser.getCanvas();
	}

	public Canvas getCanvas() {
		return myCanvas;
	}

}
