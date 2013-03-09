
package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * PenUp Command
 * 
 * @author Jack Matteucci
 */

public class PenUpCommand extends TurtleCommand {


	public PenUpCommand(TurtleCommandInput input) {
		super(input);
	}

	public PenUpCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().liftUpPen();
		return 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new PenUpCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}