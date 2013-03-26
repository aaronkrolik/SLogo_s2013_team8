package commands.ColorCommands;

import java.awt.Color;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;
import commands.TurtleCommands.TurtleCommandInput;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
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

	public SetBackGroundCommand(ColorCommandInput input) throws ExpectedInput {
		super(input);
		myCanvas = input.getCanvas();
		index = input.getBundledInt();
	}

	public SetBackGroundCommand() {
	}

	@Override
	public Integer execute() {
		Color color = super.getColors().get(index.getInteger());
		myCanvas.setBackground(color);
		return index.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new SetBackGroundCommand(
				(ColorCommandInput) super.createCommandInput(parser, line));
	}

}