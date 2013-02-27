package commands;

import java.util.List;
import java.util.Scanner;

import util.Parser;

import model.SlogoModel;

public class CommandInput {
	SlogoModel myModel;
	Scanner myLine;
	public CommandInput(SlogoModel model, Scanner line) {
		myModel =  model;
		myLine = line;
	}

	public SlogoModel getModel(){
		return myModel;
	}
	
	public Scanner getLine(){
		return myLine;
	}
	
	public String getString(){
		return Parser.getNextString(myLine);
	}
	
	public double getDouble(){
		return Parser.getNextDouble(myLine);
	}
	
	public Integer getInt(){
		return Parser.getNextInt(myModel, myLine);
	}
	
	public List<Command> getCommandList(){
		return Parser.getNextCommandList(myModel, myLine);
	}
	
}
