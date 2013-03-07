package commands;

<<<<<<< HEAD:src/commands/Command.java
import java.util.Scanner;

=======
>>>>>>> SLOGO First Merged Draft:src/commands/Command.java
import model.SlogoModel;

public abstract class Command {
	private CommandInput myInput;
	
	public Command(CommandInput input){
		myInput = input;
	}
	
<<<<<<< HEAD:src/commands/Command.java
=======
	protected SlogoModel getModel(){
		return myInput.getModel();
	}
	
>>>>>>> SLOGO First Merged Draft:src/commands/Command.java
	protected CommandInput getInput(){
	  	return myInput;
	}
	
	public abstract Integer execute();

}
