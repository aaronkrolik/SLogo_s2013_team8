package commands.MapCommands;

import java.util.Map;
import java.util.Scanner;

import commands.Command;
import commands.CommandInput;

import util.MapInterface;
import util.ParsingInterface;
import util.TurtleInterface;

public abstract class MapCommand extends Command {
	private Map<String, Integer> myVariableMap;
	private Map<String, VariableInput> myCommandMap;
	
	public MapCommand(){
	}
	
	public MapCommand(MapCommandInput input) {
		super(input);
		myVariableMap = input.getVariableMap();
		myCommandMap =  input.getCommandMap();
	}
	
	protected Map getVariableMap(){
		return myVariableMap;
	}
	
	public Map getCommandMap(){
		return myCommandMap;
	}
	@Override
	public CommandInput createCommandInput(ParsingInterface parser, Scanner line){
		return new MapCommandInput((MapInterface) parser, line);
	}

}
