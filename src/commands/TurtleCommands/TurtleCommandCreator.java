package commands.TurtleCommands;

import java.util.Scanner;

import commands.CommandCreator;
import commands.CommandInput;

import util.MapInterface;
import util.ParsingInterface;
import util.TurtleInterface;

public abstract class TurtleCommandCreator extends CommandCreator {

	@Override
	public CommandInput createCommandInput(ParsingInterface parser, Scanner line){
		CommandInput input = new TurtleCommandInput((TurtleInterface) parser, line);
		return input;
	}
	
}
