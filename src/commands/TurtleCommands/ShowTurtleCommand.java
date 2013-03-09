

package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * ShowTurtle Command
 * 
 * @author Jack Matteucci
 */

public class ShowTurtleCommand extends TurtleCommand {


	public ShowTurtleCommand(TurtleCommandInput input) {
		super(input);
	}

	public ShowTurtleCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().makeVisible() ;
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new ShowTurtleCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}