package commands.MapCommands;

import java.util.Iterator;
import java.util.List;

import commands.Command;

import util.BundledInteger;

public class VariableCommand extends MapCommand {
	List<Command> myCommandList;
	List<String> myVariableList;
	List<BundledInteger> myValueList;
	
	
	public VariableCommand(MapCommandInput input, VariableInput vinput) {
		super(input);
		myVariableList = vinput.getVariableList();
		myCommandList = vinput.getCommandList();
		if(myVariableList.size() != 0){
		Iterator<String> iter = myVariableList.iterator();
		myValueList = input.getBundledIntList();
		if(myValueList.size() != 0){
		for(BundledInteger i : myValueList){
			System.out.println(i.getInteger());
			super.getVariableMap().put(":" + iter.next(), i.getInteger());
		}
		}
		}
	}

	@Override
	public Integer execute() {
		System.out.println(myCommandList);
		Integer myReturn = 0;
			for(Command c: myCommandList){
				myReturn = c.execute();
			}
		return myReturn;
	}

}
