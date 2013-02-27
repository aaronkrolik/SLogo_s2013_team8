package commands;

public class ForwardCommand extends Command {
	private Integer myDistance;
	
	public ForwardCommand(CommandInput input) {
		super(input);
		myDistance = super.getInput().getInt();
	}
	
	@Override
	public Integer execute() {
		super.getModel().getTurtle().forward(myDistance);
		return myDistance;
	}
}
