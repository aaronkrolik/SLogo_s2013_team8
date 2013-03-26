
package commands.TurtleCommands;

import java.util.Scanner;

import commands.CanvasCommandInput;
import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import view.Canvas;
import model.Turtle;

/**
 * Set Background command
 * 
 * @author Jack Matteucci
 */

public class SetBackGroundCommand extends ColorCommand {
	Canvas myCanvas;

	public SetBackGroundCommand(CanvasCommandInput input) {
		super(input);
		myCanvas = input.getCanvas();
	}

	public SetBackGroundCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().;
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new SetBackGroundCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}