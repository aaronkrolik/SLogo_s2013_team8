package commands;

import java.util.Iterator;
import java.util.List;

public class VariableCommand extends Command {
	List<Command> myCommandList;
	String myName;
	List<String> myVariableList;
	List<Integer> myValueList;
	
	
	public VariableCommand(CommandInput input, String type) {
		super(input);
		myName = type;
		myVariableList = input.getModel().getToMap().get(myName).getVariableList();
		myCommandList = input.getModel().getToMap().get(myName).getCommandList();
		if(myVariableList.size() != 0){
		Iterator<String> iter = myVariableList.iterator();
		myValueList = input.getIntList();
		for(Integer i : myValueList){
			System.out.println(i);
			input.getModel().getVariableMap().put(":" + iter.next(), i);
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
