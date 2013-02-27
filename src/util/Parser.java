package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
<<<<<<< HEAD

import commands.Command;
import commands.CommandCreator;
import commands.CommandInput;
import commands.RepeatCreator;
import commands.SumCreator;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.MakeCreator;
import commands.MapCommands.ToCreator;
import commands.TurtleCommands.BackwardCreator;
import commands.TurtleCommands.ForwardCreator;
import commands.TurtleCommands.LeftCreator;
import commands.TurtleCommands.RightCreator;


import model.SlogoModel;
import model.Turtle;

public class Parser implements ParsingInterface, TurtleInterface, MapInterface {

	private Scanner myLine;
	private Turtle myTurtle;
	private List<Command> myReturn;
	private Map<String, CommandCreator> myCommandMap;
	private Map<String, Integer> myVariableMap;
=======
import commands.Command;
import commands.CommandCreator;
import commands.CommandInput;

import model.SlogoModel;

public class Parser {

	private Scanner myline;
	private SlogoModel myModel;
	private List<Integer> myReturn;
>>>>>>> SLOGO First Merged Draft
	private final static String FORWARD_BRACKET = "\\[";
	private final static String BACK_BRACKET = "]";
	private final static String VARIABLE_TAG = ":";

<<<<<<< HEAD
	public Parser(Turtle turtle) {
		myCommandMap = new HashMap<String, CommandCreator>();
		myVariableMap = new HashMap<String, Integer>();
		/*
		 * Maybe a better way?? 
		 * Make a Factory file?
		 */
		CommandCreator forward = new ForwardCreator();
		myCommandMap.put("Forward",forward);
		CommandCreator repeat = new RepeatCreator();
		myCommandMap.put("Repeat",repeat);
		CommandCreator make = new MakeCreator();
		myCommandMap.put("Make",make);
		CommandCreator sum = new SumCreator();
		myCommandMap.put("Sum",sum);
		CommandCreator back = new BackwardCreator();
		myCommandMap.put("Backward",back);
		CommandCreator to = new ToCreator();
		myCommandMap.put("To", to);
		CommandCreator right = new RightCreator();
		myCommandMap.put("Right", right);
		CommandCreator left = new LeftCreator();
		myCommandMap.put("Left", left);
		myTurtle = turtle;
	}
    public Map<String, CommandCreator> getCommandMap(){
    	return myCommandMap;
    }
    
    
    public Map<String, Integer> getVariableMap(){
    	return myVariableMap;
    }
    
	public Turtle getTurtle() {
		return myTurtle;
	}

	public List<Command> executeCommandLine(Scanner line){
		myReturn = new ArrayList<Command>();
		while(line.hasNext()){
			Command command = getNextCommand(line);
			myReturn.add(command);
=======
	public Parser(SlogoModel model) {
		myModel = model;
	}

	public List<Integer> executeCommandLine(Scanner line){
		myReturn = new ArrayList<Integer>();
		while(line.hasNext()){
			Command command = getNextCommand(myModel,line);
			myReturn.add(command.execute());
>>>>>>> SLOGO First Merged Draft
			while(line.hasNext(BACK_BRACKET)){
				line.next();
			}
		}
		System.out.println(myReturn);
		return myReturn;
	}

<<<<<<< HEAD
	public Command getNextCommand(Scanner line){
		if (line.hasNext()){
			String type = line.next();
			System.out.println(type);
			if(myCommandMap.containsKey(type)){
				CommandCreator creator = (CommandCreator) myCommandMap.get(type);
				CommandInput input = creator.createCommandInput(this, line);
				return creator.createCommand(input);	
			}
		}
		System.out.println("Command");
		return null;
	}
	

	public List<Command> getNextCommandList(Scanner line) {
		List<Command> commands = new ArrayList<Command>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				line.next();
				while(!line.hasNext(BACK_BRACKET)){		
					commands.add(getNextCommand(line));
				}
				line.next();
			}
			return commands;
		}
		System.out.println("CommandList");
		return null;
	}
	
	
=======
	public static Command getNextCommand(SlogoModel model, Scanner line){
		if (line.hasNext()){
			String type = line.next();
			System.out.println(type);
			if(!model.getCommandMap().containsKey(type)){
				System.out.println("NoKey");
				return null;
			}
			else{
				CommandCreator creator = (CommandCreator) model.getCommandMap().get(type);
				CommandInput input = creator.createCommandInput(model, line);
				return creator.createCommand(input);		
			}
		}
		System.out.println("Command");
		return null;
	}
>>>>>>> SLOGO First Merged Draft

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
<<<<<<< HEAD
	
	public String getNextString(Scanner line){
=======

	public static double getNextDouble(Scanner line){
		if (line.hasNextDouble()){
			return line.nextDouble();
		}
		else{
			return 0;
		}
	}

	public static String getNextString(Scanner line){
>>>>>>> SLOGO First Merged Draft
		if (line.hasNext()){
			return line.next();
		}
		else{
			return "";
		}
	}

<<<<<<< HEAD

	public List<String> getNextStringList(Scanner line) {
		List<String> strings = new ArrayList<String>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				line.next();
				while(!line.hasNext(BACK_BRACKET)){
					strings.add(line.next());
				}
				line.next();
			}
			return strings;
		}
		System.out.println("CommandList");
		return null;
	}
	
	public BundledInteger getNextBundledInt(Scanner line){
=======
	public static Integer getNextInt(SlogoModel model, Scanner line){
>>>>>>> SLOGO First Merged Draft
		while(line.hasNext(FORWARD_BRACKET)){
			line.next();
		}
		if (line.hasNextInt()){
<<<<<<< HEAD
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

	public boolean HasCommand(Scanner line){
		for(Object s : myCommandMap.keySet()){
			if(line.hasNext((String) s)){
				return true;
			}
		}
		return false;
	}
	public boolean HasVarable(Scanner line){
		for(Object s : myVariableMap.keySet()){
=======
			return line.nextInt();
		}
		else{
			if(HasCommand(model,line)){
				return getNextCommand(model,line).execute();
			}
			return getVariable(model, line);
		}
	}

	private static boolean HasCommand(SlogoModel model, Scanner line){
		for(Object s : model.getCommandMap().keySet()){
>>>>>>> SLOGO First Merged Draft
			if(line.hasNext((String) s)){
				return true;
			}
		}
		return false;
	}

<<<<<<< HEAD
	private int getVariable(Scanner line){
		String type = line.next();
		if(type.charAt(0) == VARIABLE_TAG.charAt(0)){
			if(myVariableMap.containsKey(type)){
				return (Integer) myVariableMap.get(type);
=======
	private static int getVariable(SlogoModel model, Scanner line){
		String type = line.next();
		if(type.charAt(0) == VARIABLE_TAG.charAt(0)){
			if(model.getVariableMap().containsKey(type)){
				return (Integer) model.getVariableMap().get(type);
>>>>>>> SLOGO First Merged Draft
			}
			return 0;
		}
		return 0; //BUGBUG need to throw exception
	}
<<<<<<< HEAD
	
	public List<BundledInteger> getNextIntegerList(Scanner line) {
		List<BundledInteger> integers = new ArrayList<BundledInteger>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				line.next();
				while(!line.hasNext(BACK_BRACKET)){
					integers.add(getNextBundledInt(line));
				}
				line.next();
			}
			return integers;
=======



	public static List<Command> getNextCommandList(SlogoModel model, Scanner line) {
		List<Command> commands = new ArrayList<Command>();
		if(line.hasNext()){
			if(line.next().equals(FORWARD_BRACKET)){
				while(!line.hasNext(BACK_BRACKET)){		
					commands.add(getNextCommand(model, line));
				}
				line.next();
			}
			return commands;
>>>>>>> SLOGO First Merged Draft
		}
		System.out.println("CommandList");
		return null;
	}

}
