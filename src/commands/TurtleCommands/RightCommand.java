package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class RightCommand extends TurtleCommand {
	private BundledInteger myAngle;
	
	public RightCommand(TurtleCommandInput input) {
		super(input);
		myAngle = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		super.getTurtle().right(angle);
		return angle;
	}

}