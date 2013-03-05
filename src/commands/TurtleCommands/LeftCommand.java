package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class LeftCommand extends TurtleCommand {
	private BundledInteger myAngle;
	
	public LeftCommand(TurtleCommandInput input) {
		super(input);
		myAngle = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		super.getTurtle().left(angle);
		return angle;
	}

}