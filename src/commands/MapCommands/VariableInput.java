package commands.MapCommands;

import java.util.List;
import java.util.Scanner;

import commands.Command;

import model.SlogoModel;

public class VariableInput {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;

	public VariableInput(String name, List<String> VariableList, List<Command> CommandList) {
		myName = name;
		myVariableList = VariableList;
		myCommandList = CommandList;
	}
	
	public String getName(){
		return myName;
	}
	
	public List<String> getVariableList(){
		return myVariableList;
	}
		
	public List<Command> getCommandList(){
		 return myCommandList;
	}
	
	
}
