package Simulation;

public class ForwardCommand extends Command {
	private Integer myDistance;
	
	public ForwardCommand(CommandInput input) {
		super(input);
		myDistance = super.getInput().getInt();
	}
	@Override
	public Integer execute() {
		super.getModel().getTurtle().Forward(myDistance);
		return myDistance;
	}

}
