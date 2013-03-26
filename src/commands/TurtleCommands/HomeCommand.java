package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * Home Command
 * 
 * @author Jack Matteucci
 */

public class HomeCommand extends TurtleCommand {

	public HomeCommand(TurtleCommandInput input) {
		super(input);
	}

	public HomeCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().home();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new HomeCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}