
package commands.ColorCommands;

import java.util.Scanner;

import commands.CanvasCommandInput;
import commands.Command;
import commands.RepeatCommand;
import commands.TurtleCommands.TurtleCommandInput;

import util.BundledInteger;
import util.ParsingInterface;
import view.Canvas;
import model.Turtle;

/**
 * PenDown Command
 * 
 * @author Jack Matteucci
 */

public class SetBackGroundCommand extends ColorCommand {
	Canvas myCanvas;
	BundledInteger index;

	public SetBackGroundCommand(CanvasCommandInput input) {
		super(input);
		myCanvas = input.getCanvas();
		
	}

	public SetBackGroundCommand() {
	}

	@Override
	public Integer execute() {
		super.getColors().get(index.getInteger());
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new SetBackGroundCommand((CanvasCommandInput) super.createCommandInput(
				parser, line));
	}

}