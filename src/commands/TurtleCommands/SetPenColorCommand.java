package commands.TurtleCommands;

import java.awt.Color;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;
import commands.ColorCommands.ColorCommandInput;

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

public class SetPenColorCommand extends TurtleCommand {
	BundledInteger index;

	public SetPenColorCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		index = input.getBundledInt();

	}

	public SetPenColorCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().setpencolor(index.getInteger());
		return index.getInteger();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line)
			throws ExpectedInput {
		return new SetPenColorCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}