
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

public class HideTurtleCommand extends TurtleCommand {


	

	public HideTurtleCommand() {
	}

	@Override
	public Integer execute() {
		super.getTurtle().ToggleVisibility() ;
		return 0;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new RightCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}