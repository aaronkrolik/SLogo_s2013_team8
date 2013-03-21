
package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Clear Command
 * 
 * @author Jack Matteucci
 */

public class ClearCommand extends TurtleCommand {


	public ClearCommand(TurtleCommandInput input) {
		super(input);
	}

	public ClearCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().clear();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new ClearCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}