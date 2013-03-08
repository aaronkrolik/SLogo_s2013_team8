package commands.TurtleCommands;


import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

public class LeftCommand extends TurtleCommand {
	private BundledInteger myAngle;
	
	public LeftCommand(TurtleCommandInput input) {
		super(input);
		myAngle = input.getBundledInt();
	}
	
	
	public LeftCommand() {
	}


	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		super.getTurtle().left(angle);
		return angle;
	}
	
	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new LeftCommand((TurtleCommandInput) super.createCommandInput(parser, line));
	}

}