package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import commands.Command;
import commands.CommandInput;
import commands.RepeatCommand;
import commands.SumCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.ToCommand;
import commands.TurtleCommands.BackwardCommand;
import commands.TurtleCommands.ForwardCommand;
import commands.TurtleCommands.LeftCommand;
import commands.TurtleCommands.RightCommand;


import model.SlogoModel;
import model.Turtle;

public class Parser implements ParsingInterface, TurtleInterface, MapInterface {

	private Scanner myLine;
	private Turtle myTurtle;
	private List<Command> myReturn;
	private Map<String, Command> myCommandMap;
	private Map<String, Integer> myVariableMap;
	private final static String FORWARD_BRACKET = "\\[";
	private final static String BACK_BRACKET = "]";
	private final static String VARIABLE_TAG = ":";
	private int BracketCount;

	public Parser(Turtle turtle) {
		myCommandMap = new HashMap<String, Command>();
		myVariableMap = new HashMap<String, Integer>();
		/*
		 * Maybe a better way?? 
		 * Make a Factory file?
		 */
		Command forward = new ForwardCommand();
		myCommandMap.put("Forward",forward);
		Command repeat = new RepeatCommand();
		myCommandMap.put("Repeat",repeat);
		Command make = new MakeCommand();
		myCommandMap.put("Make",make);
		Command sum = new SumCommand();
		myCommandMap.put("Sum",sum);
		Command back = new BackwardCommand();
		myCommandMap.put("Backward",back);
		Command to = new ToCommand();
		myCommandMap.put("To", to);
		Command right = new RightCommand();
		myCommandMap.put("Right", right);
		Command left = new LeftCommand();
		myCommandMap.put("Left", left);
		myTurtle = turtle;
	}
    public Map<String, Command> getCommandMap(){
    	return myCommandMap;
    }
    
    
    public Map<String, Integer> getVariableMap(){
    	return myVariableMap;
    }
    
	public Turtle getTurtle() {
		return myTurtle;
	}

	public List<Command> executeCommandLine(Scanner line){
		BracketCount = 0;
		myReturn = new ArrayList<Command>();
		while(line.hasNext()){
			checkBrackets();
			Command command = getNextCommand(line);
			myReturn.add(command);
			while(line.hasNext(BACK_BRACKET)){
				tallyBrackets(line);
				line.next();
			}
		}
		checkBrackets();
		System.out.println(myReturn);
		return myReturn;
	}

	public Command getNextCommand(Scanner line){
		if (line.hasNext()){
			String type = line.next();
			System.out.println(type);
			if(myCommandMap.containsKey(type)){
				Command command = (Command) myCommandMap.get(type);
				return command.createCommand(this, line);	
			}
		}
		System.out.println("Command");
		return null;
	}
	

	public List<Command> getNextCommandList(Scanner line) {
		List<Command> commands = new ArrayList<Command>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				tallyBrackets(line);
				line.next();
				while(!line.hasNext(BACK_BRACKET)){		
					commands.add(getNextCommand(line));
				}
				tallyBrackets(line);
				line.next();
			}
			return commands;
		}
		System.out.println("CommandList");
		return null;
	}
	
	

	//	public static Integer getNextVariable(Model model, Scanner line){	
	//		if (line.hasNext()){
	//			String type = line.next();
	//			System.out.println(type);	
	//		if(!model.getVariableMap().containsKey(type)){
	//			System.out.println("NoKey");
	//			return null;
	//			}
	//			else{
	//				return (Integer) model.getVariableMap().get(type);
	//			}	
	//	}
	//		System.out.println("Command");
	//		return null;		
	//		
	//	}
	
	public String getNextString(Scanner line){
		if (line.hasNext()){
			return line.next();
		}
		else{
			return "";
		}
	}


	public List<String> getNextStringList(Scanner line) {
		List<String> strings = new ArrayList<String>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				tallyBrackets(line);
				line.next();
				while(!line.hasNext(BACK_BRACKET)){
					strings.add(line.next());
				}
				tallyBrackets(line);
				line.next();
			}
			return strings;
		}
		System.out.println("CommandList");
		return null;
	}
	
	public BundledInteger getNextBundledInt(Scanner line){
		while(line.hasNext(FORWARD_BRACKET)){
			tallyBrackets(line);
			line.next();
		}
		if (line.hasNextInt()){
			return new BundledInteger(line.nextInt());
		}
		else{
			if(HasCommand(line)){
				return new BundledInteger(getNextCommand(line));
			}
			String var = line.next();
			if(!myVariableMap.containsKey(var)){
				myVariableMap.put(var, 0);
			}
			return new BundledInteger(var, myVariableMap); // Bug Bug check if it should be a var
			}
		}

	private boolean HasCommand(Scanner line){
		for(Object s : myCommandMap.keySet()){
			if(line.hasNext((String) s)){
				return true;
			}
		}
		return false;
	}
	private boolean HasVarable(Scanner line){
		for(Object s : myVariableMap.keySet()){
			if(line.hasNext((String) s)){
				return true;
			}
		}
		return false;
	}

	private int getVariable(Scanner line){
		String type = line.next();
		if(type.charAt(0) == VARIABLE_TAG.charAt(0)){
			if(myVariableMap.containsKey(type)){
				return (Integer) myVariableMap.get(type);
			}
			return 0;
		}
		return 0; //BUGBUG need to throw exception
	}
	
	public List<BundledInteger> getNextIntegerList(Scanner line) {
		List<BundledInteger> integers = new ArrayList<BundledInteger>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				tallyBrackets(line);
				line.next();
				while(!line.hasNext(BACK_BRACKET)){
					integers.add(getNextBundledInt(line));
				}
				tallyBrackets(line);
				line.next();
			}
			return integers;
		}
		System.out.println("CommandList");
		return null;
	}
	private void tallyBrackets(Scanner line){
		if(line.hasNext(FORWARD_BRACKET)) BracketCount ++;
		else if(line.hasNext(BACK_BRACKET)) BracketCount --;
	}
	private void checkBrackets(){
		if( BracketCount != 0) System.out.println("Mismatched Brackets!");//EXCEPTION
	}

}
