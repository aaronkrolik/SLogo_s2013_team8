
package commands.ColorCommands;

import java.awt.Color;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;
import commands.TurtleCommands.TurtleCommandInput;

import util.BundledInteger;
import util.ColorController;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import view.Canvas;
import model.Turtle;

/**
 * PenDown Command
 * 
 * @author Jack Matteucci
 */

public class SetPaletteCommand extends ColorCommand {
	Canvas myCanvas;
	BundledInteger index;
	BundledInteger r;
	BundledInteger g;
	BundledInteger b;
	

	public SetPaletteCommand(ColorCommandInput input) throws ExpectedInput {
		super(input);
		myCanvas = input.getCanvas();
		index = input.getBundledInt();
		r= input.getBundledInt();
		g = input.getBundledInt();
		b = input.getBundledInt();
		
	}

	public SetPaletteCommand() {
	}

	@Override
	public Integer execute() {
		super.getColors().getMap().put(index.getInteger(), ColorController.RGBtoColor(r.getInteger(), g.getInteger(), b.getInteger()));
		return index.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new SetPaletteCommand((ColorCommandInput) super.createCommandInput(
				parser, line));
	}

}