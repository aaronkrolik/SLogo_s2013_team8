
package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Heading Command
 * 
 * @author Jack Matteucci
 */

public class HeadingCommand extends TurtleCommand {


	public HeadingCommand(TurtleCommandInput input) {
		super(input);
	}

	public HeadingCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().heading();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new HeadingCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}