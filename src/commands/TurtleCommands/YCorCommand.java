package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * YCor Command
 * 
 * @author Jack Matteucci
 */

public class YCorCommand extends TurtleCommand {

	public YCorCommand(TurtleCommandInput input) {
		super(input);
	}

	public YCorCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().ycor();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new YCorCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}