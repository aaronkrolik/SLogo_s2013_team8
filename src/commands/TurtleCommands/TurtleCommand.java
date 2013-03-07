package commands.TurtleCommands;

import commands.Command;

import model.Turtle;

public abstract class TurtleCommand extends Command {
	private Turtle myTurtle;
	
	public TurtleCommand(TurtleCommandInput input) {
		super(input);
		myTurtle = input.getTurtle();
	}
	
	protected Turtle getTurtle(){
		return myTurtle;
	}

}
