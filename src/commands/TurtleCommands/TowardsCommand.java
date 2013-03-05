package commands.TurtleCommands;


import util.BundledInteger;
import model.Turtle;

public class TowardsCommand extends TurtleCommand {
	private BundledInteger myX;
	private BundledInteger myY;
	
	public TowardsCommand(TurtleCommandInput input) {
		super(input);
		myX = input.getBundledInt();
		myY = input.getBundledInt();
	}
	
	
	@Override
	public Integer execute() {
		Integer x = myY.getInteger();
		Integer y = myY.getInteger();
		return super.getTurtle().towards(x,y);	
	}

}