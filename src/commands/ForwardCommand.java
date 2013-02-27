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
<<<<<<< HEAD:src/commands/ForwardCommand.java
		System.out.println(myDistance);
=======
>>>>>>> SLOGO First Merged Draft:src/commands/ForwardCommand.java
		return myDistance;
	}
}
