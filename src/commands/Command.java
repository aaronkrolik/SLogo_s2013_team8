package commands;

import java.util.Scanner;

import model.SlogoModel;

public abstract class Command {
	private CommandInput myInput;
	
	public Command(CommandInput input){
		myInput = input;
	}
	
	protected CommandInput getInput(){
	  	return myInput;
	}
	
	public abstract Integer execute();

}
