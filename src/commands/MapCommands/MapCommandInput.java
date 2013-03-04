package commands.MapCommands;

import java.util.Map;
import java.util.Scanner;

import commands.CommandInput;

import util.MapInterface;
import util.ParsingInterface;

public class MapCommandInput extends CommandInput {
	private Map<String, Integer> myVariableMap;
	private Map<String, VariableInput> myCommandMap;
	
	public MapCommandInput(MapInterface parser, Scanner line) {
		super(parser, line);
		myVariableMap = parser.getVariableMap();
		myCommandMap = parser.getCommandMap();
	}
	
	public Map getVariableMap(){
		return myVariableMap;
	}
	
	public Map getCommandMap(){
		return myCommandMap;
	}

}
