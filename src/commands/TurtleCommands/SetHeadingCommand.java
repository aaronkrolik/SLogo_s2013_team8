package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class SetHeadingCommand extends TurtleCommand {
	private BundledInteger myAngle;
	
	public SetHeadingCommand(TurtleCommandInput input) {
		super(input);
		myAngle = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer angle = myAngle.getInteger();
		return super.getTurtle().setheading(angle);
	}

}