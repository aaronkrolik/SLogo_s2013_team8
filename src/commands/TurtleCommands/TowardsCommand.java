package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;
import model.Turtle;

/**
 * Towards Command
 * 
 * @author Jack Matteucci
 */

public class TowardsCommand extends TurtleCommand {
	private BundledInteger myX;
	private BundledInteger myY;

	public TowardsCommand() {
	}

	public TowardsCommand(TurtleCommandInput input) throws ExpectedInput {
		super(input);
		myX = input.getBundledInt();
		myY = input.getBundledInt();
	}

	@Override
	public Integer execute() {
		Integer x = myY.getInteger();
		Integer y = myY.getInteger();
		return super.getTurtle().towards(x, y);
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new TowardsCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}