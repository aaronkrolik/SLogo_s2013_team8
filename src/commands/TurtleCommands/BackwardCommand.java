package commands.TurtleCommands;


import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

public class BackwardCommand extends TurtleCommand {
	private BundledInteger myDistance;
	
	public BackwardCommand(TurtleCommandInput input) {
		super(input);
		myDistance = input.getBundledInt();
	}
	
	public BackwardCommand() {
	}

	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		super.getTurtle().backward(distance);
		System.out.println(myDistance);
		return distance;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new BackwardCommand((TurtleCommandInput) super.createCommandInput(parser, line));
	}
}
