package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class BackwardCommand extends TurtleCommand {
	private BundledInteger myDistance;
	
	public BackwardCommand(TurtleCommandInput input) {
		super(input);
		myDistance = input.getBundledInt();
	}
	
	@Override
	public Integer execute() {
		Integer distance = myDistance.getInteger();
		super.getTurtle().backward(distance);
		System.out.println(myDistance);
		return distance;
	}

}
