package commands;

import model.SlogoModel;

public abstract class Command {
	private CommandInput myInput;
	private String myName;
	
	public Command(CommandInput input){
		myInput = input;
	}
	
	protected SlogoModel getModel(){
		return myInput.getModel();
	}
	public void setName(String name){
		myName = name;
	}
	
	protected void getName(String name){
		myName = name;
	}
	
	
	protected CommandInput getInput(){
		return myInput;
	}
	
	public abstract Integer execute();
}
