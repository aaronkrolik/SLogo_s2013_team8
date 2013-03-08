package commands.TurtleCommands;


import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

public class SetHeadingCommand extends TurtleCommand {
	private BundledInteger myAngle;
	
	public SetHeadingCommand(TurtleCommandInput input) {
		super(input);
		myAngle = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		return super.getTurtle().setheading(angle);
	}
	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new SetHeadingCommand((TurtleCommandInput) super.createCommandInput(parser, line));
	}

}