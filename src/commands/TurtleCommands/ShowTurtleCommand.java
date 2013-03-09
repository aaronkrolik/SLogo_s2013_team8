

package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Right Command
 * 
 * @author Jack Matteucci
 */

public class ShowTurtleCommand extends TurtleCommand {


	

	public ShowTurtleCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().ToggleVisibility() ;
		return 1;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RightCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}