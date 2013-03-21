package util;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

/**
 * Houses The Command List
 * 
 * @author Jack Matteucci
 */

public class CommandSequence {
	List<Command> myCommandList;

	public CommandSequence() {
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}
	
	public void setCommandList(List<Command> commands) {
		myCommandList = commands;
	}

}
