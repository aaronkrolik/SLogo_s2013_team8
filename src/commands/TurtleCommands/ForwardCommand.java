package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Forward Command
 * 
 * @author Jack Matteucci
 */

public class ForwardCommand extends TurtleCommand {
	private BundledInteger myDistance;

	public ForwardCommand(TurtleCommandInput input) {
		super(input);
		myDistance = input.getBundledInt();
	}

	public ForwardCommand() {
	}

	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		System.out.println("forward" + distance);
		super.getTurtle().forward(distance);
		return distance;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new ForwardCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
