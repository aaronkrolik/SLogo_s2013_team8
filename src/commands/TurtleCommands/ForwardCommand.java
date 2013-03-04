package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class ForwardCommand extends TurtleCommand {
	private BundledInteger myDistance;
	
	public ForwardCommand(TurtleCommandInput input) {
		super(input);
		myDistance = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		System.out.println("forward" + distance);
		super.getTurtle().forward(distance);
		return distance;
	}

}
