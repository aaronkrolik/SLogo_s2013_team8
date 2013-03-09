
package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Showing Command
 * 
 * @author Jack Matteucci
 */

public class ShowingCommand extends TurtleCommand {


	public ShowingCommand(TurtleCommandInput input) {
		super(input);
	}

	public ShowingCommand() {
	}

	@Override
	public Integer execute() {
		if(super.getTurtle().getVisibility()) return 1;
		return 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new ShowingCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}