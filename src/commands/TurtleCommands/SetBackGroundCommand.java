package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;
import commands.ColorCommands.ColorCommand;
import commands.ColorCommands.ColorCommandInput;

import util.BundledInteger;
import util.ColorController;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import view.Canvas;
import model.Turtle;

/**
 * Set Background command
 * 
 * @author Jack Matteucci
 */

public class SetBackGroundCommand extends ColorCommand {
	Canvas myCanvas;
	ColorController myColorController;
	BundledInteger index;

	public SetBackGroundCommand(ColorCommandInput input) throws ExpectedInput {
		super(input);
		myCanvas = input.getCanvas();
		myColorController = input.getColors();
		index = input.getBundledInt();
	}

	public SetBackGroundCommand() {
	}

	@Override
	public Integer execute() {
		myCanvas.setBackground(myColorController.get(index.getInteger()));
		return index.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new SetBackGroundCommand(
				(ColorCommandInput) super.createCommandInput(parser, line));
	}

}