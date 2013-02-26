package Simulation;

public class MakeCommand extends Command {
	private final static String VARIABLE_TAG = ":";
	
	private String myName;
	private Integer myValue;
	
	
	public MakeCommand(CommandInput input) {
		super(input);
		myName = VARIABLE_TAG + super.getInput().getString();
		myValue = super.getInput().getInt();
	}
	@Override
	public Integer execute() {
		super.getModel().getVariableMap().put(myName, myValue);
		return myValue;
	}

}
