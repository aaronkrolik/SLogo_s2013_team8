package commands.MapCommands;

import java.util.Scanner;

import commands.CommandCreator;
import commands.CommandInput;

import util.MapInterface;
import util.ParsingInterface;

public abstract class MapCommandCreator extends CommandCreator {

	public MapCommandCreator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandInput createCommandInput(ParsingInterface parser, Scanner line){
		CommandInput input = new MapCommandInput((MapInterface) parser, line);
		return input;
	}
}
