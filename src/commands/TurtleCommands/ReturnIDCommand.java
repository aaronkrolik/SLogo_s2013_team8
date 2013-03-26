package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * PenDown Command
 * 
 * @author abk
 */

public class ReturnIDCommand extends TurtleCommand {

	public ReturnIDCommand(TurtleCommandInput input) {
		super(input);
	}

	public ReturnIDCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().getTurtleID();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new ReturnIDCommand(
				(TurtleCommandInput) super.createCommandInput(parser, line));
	}

}