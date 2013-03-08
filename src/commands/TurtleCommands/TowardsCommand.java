package commands.TurtleCommands;


import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import model.Turtle;

public class TowardsCommand extends TurtleCommand {
	private BundledInteger myX;
	private BundledInteger myY;
	
	public TowardsCommand() {
	}
	
	public TowardsCommand(TurtleCommandInput input) {
		super(input);
		myX = input.getBundledInt();
		myY = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer x = myY.getInteger();
		Integer y = myY.getInteger();
		return super.getTurtle().towards(x,y);	
	}
	
	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new TowardsCommand((TurtleCommandInput) super.createCommandInput(parser, line));
	}

}