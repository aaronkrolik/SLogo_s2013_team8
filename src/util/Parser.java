package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import commands.Command;
import commands.CommandCreator;
import commands.CommandInput;
import commands.MakeCommand;
import commands.VariableCommand;

import model.SlogoModel;

public class Parser {

	private Scanner myline;
	private SlogoModel myModel;
	private List<Command> myReturn;
	private final static String FORWARD_BRACKET = "\\[";
	private final static String BACK_BRACKET = "]";
	private final static String VARIABLE_TAG = ":";

	public Parser(SlogoModel model) {
		myModel = model;
	}

	public List<Command> executeCommandLine(Scanner line){
		myReturn = new ArrayList<Command>();
		while(line.hasNext()){
			Command command = getNextCommand(myModel,line);
			myReturn.add(command);
			while(line.hasNext(BACK_BRACKET)){
				line.next();
			}
		}
		System.out.println(myReturn);
		return myReturn;
	}

	public static Command getNextCommand(SlogoModel model, Scanner line){
		if (line.hasNext()){
			String type = line.next();
			System.out.println(type);
			if(model.getCommandMap().containsKey(type)){
				CommandCreator creator = (CommandCreator) model.getCommandMap().get(type);
				CommandInput input = creator.createCommandInput(model, line);
				return creator.createCommand(input);	
			}
			else if(model.getToMap().containsKey(type)){
				CommandInput input = new CommandInput(model,line);
				Command variablecommand = new VariableCommand(input, type);
				return variablecommand;
				
			}
		}
		System.out.println("Command");
		return null;
	}
	

	public static List<Command> getNextCommandList(SlogoModel model, Scanner line) {
		List<Command> commands = new ArrayList<Command>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				line.next();
				while(!line.hasNext(BACK_BRACKET)){		
					commands.add(getNextCommand(model, line));
				}
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
	
	public static String getNextString(Scanner line){
		if (line.hasNext()){
			return line.next();
		}
		else{
			return "";
		}
	}


	public static List<String> getNextStringList(SlogoModel model, Scanner line) {
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
	
	public static Integer getNextInt(SlogoModel model, Scanner line){
		while(line.hasNext(FORWARD_BRACKET)){
			line.next();
		}
		if (line.hasNextInt()){
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
			if(line.hasNext((String) s)){
				return true;
			}
		}
		return false;
	}

	private static int getVariable(SlogoModel model, Scanner line){
		String type = line.next();
		if(type.charAt(0) == VARIABLE_TAG.charAt(0)){
			if(model.getVariableMap().containsKey(type)){
				return (Integer) model.getVariableMap().get(type);
			}
			return 0;
		}
		return 0; //BUGBUG need to throw exception
	}
	
	public static List<Integer> getNextIntegerList(SlogoModel model, Scanner line) {
		List<Integer> integers = new ArrayList<Integer>();
		if(line.hasNext()){
			if(line.hasNext(FORWARD_BRACKET)){
				line.next();
				while(!line.hasNext(BACK_BRACKET)){
					integers.add(getNextInt(model, line));
				}
				line.next();
			}
			return integers;
		}
		System.out.println("CommandList");
		return null;
	}

}
