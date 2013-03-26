package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * HideTurtle Command
 * 
 * @author Jack Matteucci
 */

public class HideTurtleCommand extends TurtleCommand {

	public HideTurtleCommand(TurtleCommandInput input) {
		super(input);
	}

	public HideTurtleCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().makeInvisible();
		return 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new HideTurtleCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}