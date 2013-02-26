package Simulation;

import java.util.List;
import java.util.Scanner;

public class CommandInput {
	Model myModel;
	Scanner myLine;
	public CommandInput(Model model, Scanner line) {
		myModel = model;
		myLine = line;
	}

	public Model getModel(){
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
