package commands;

public class BackwardCommand extends Command {
	private Integer myDistance;
	
	public BackwardCommand(CommandInput input) {
		super(input);
		myDistance = super.getInput().getInt();
	}
	
	@Override
	public Integer execute() {
		super.getModel().getTurtle().backward(myDistance);
		System.out.println(myDistance);
		return myDistance;
	}
}