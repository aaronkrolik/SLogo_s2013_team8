package commands.MapCommands;

import java.util.Map;
import java.util.Scanner;

import commands.Command;

import util.TurtleInterface;

public abstract class MapCommand extends Command {
	private Map<String, Integer> myVariableMap;
	private Map<String, VariableInput> myCommandMap;
	
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

}
