package commands.MapCommands;

import java.util.List;
import java.util.Scanner;

import commands.Command;

import model.SlogoModel;

/**
 * Carries and gives out all information needed by a particular created variable
 * command
 * 
 * @author Jack Matteucci
 */
public class VariableInput {
	String myName;
	List<String> myVariableList;
	List<Command> myCommandList;

	public VariableInput() {
	}

	public VariableInput(String name, List<String> VariableList,
			List<Command> CommandList) {
		myName = name;
		myVariableList = VariableList;
		myCommandList = CommandList;
	}

	public String getName() {
		return myName;
	}

	public List<String> getVariableList() {
		return myVariableList;
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}

}
