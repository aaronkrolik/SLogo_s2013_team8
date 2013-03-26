package commands.TurtleCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

/**
 * XCor Command
 * 
 * @author Jack Matteucci
 */

public class XCorCommand extends TurtleCommand {

	public XCorCommand(TurtleCommandInput input) {
		super(input);
	}

	public XCorCommand() {
	}

	@Override
	public Integer execute() {
		return super.getTurtle().xcor();
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new XCorCommand((TurtleCommandInput) super.createCommandInput(
				parser, line));
	}

}