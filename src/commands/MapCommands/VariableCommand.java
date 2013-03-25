package commands.MapCommands;

import java.util.Iterator;

import java.util.List;
import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * A Variable Command that is to be stored in the Command map
 * 
 * @author Jack Matteucci
 */

public class VariableCommand extends MapCommand {
	List<Command> myCommandList;
	List<String> myVariableList;
	List<BundledInteger> myValueList;
	VariableInput myVariableInput;
	String myName;

	public VariableCommand(VariableInput vinput) {
		super();
		myVariableInput = vinput;
	}

	public VariableCommand(MapCommandInput input, VariableInput vinput) throws ExpectedInput {
		super(input);
		myVariableInput = vinput;
		myVariableList = vinput.getVariableList();
		myCommandList = vinput.getCommandList();
		if (myVariableList.size() != 0) {
			Iterator<String> iter = myVariableList.iterator();
			myValueList = input.getBundledIntSequence().getBundledIntegerList();
			if (myValueList.size() != 0) {
				for (BundledInteger i : myValueList) {
					System.out.println(i.getInteger());
					super.getVariableMap().put(":" + iter.next(),
							i.getInteger());
				}
			}
		}
	}

	@Override
	public Integer execute() {
		System.out.println(myCommandList);
		Integer myReturn = 0;
		for (Command c : myCommandList) {
			if(c.getName().equals(myVariableInput.getName())){
			c = new VariableCommand(myVariableInput);
			}
			myReturn = c.execute();
		}
		return myReturn;
	}

	@Override
	public String getName(){
		return myVariableInput.getName();
	}
	
	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new VariableCommand((MapCommandInput) super.createCommandInput(
				parser, line), myVariableInput);
	}

}
