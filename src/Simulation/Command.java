package Simulation;

public abstract class Command {
	CommandInput myInput;
	
	public Command(CommandInput input){
		myInput = input;
	}
	
	protected Model getModel(){
		return myInput.getModel();
	}
	
	protected CommandInput getInput(){
		return myInput;
	}
	
	public abstract Integer execute();
}
