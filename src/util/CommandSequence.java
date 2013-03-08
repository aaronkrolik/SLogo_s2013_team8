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
		List<Command> myCommandList = new ArrayList<Command>();
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}

}
