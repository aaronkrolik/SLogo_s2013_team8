
package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * GOTO Command
 * 
 * @author Jack Matteucci
 */

public class GOTOCommand extends TurtleCommand {
	BundledInteger myX;
	BundledInteger myY;

	public GOTOCommand(TurtleCommandInput input) {
		super(input);
		myX  = super.getInput().getBundledInt();
		myY  = super.getInput().getBundledInt();
	}

	public GOTOCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().setCenter(myX.getInteger(), myY.getInteger());
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new GOTOCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}