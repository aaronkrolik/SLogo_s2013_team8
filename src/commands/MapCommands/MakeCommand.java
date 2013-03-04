package commands.MapCommands;

import util.BundledInteger;

public class MakeCommand extends MapCommand {
	private final static String VARIABLE_TAG = ":";
	
	private String myName;
	private BundledInteger myValue;
	
	
	public MakeCommand(MapCommandInput input) {
		super(input);
		myName = VARIABLE_TAG + input.getString();
		myValue = input.getBundledInt();
	}
	@Override
	public Integer execute() {
		Integer value = myValue.getInteger();
		super.getVariableMap().put(myName,value);
		return value;
	}

}
