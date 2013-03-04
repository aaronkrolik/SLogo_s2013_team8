package util;

import java.util.Map;

import commands.Command;

public class BundledInteger {
	Integer myInteger = 0;
	Command myCommand;
	String myVariable;
	Map myMap;
	
	public BundledInteger(Integer number) {
		myInteger = number;
	}
	
	public BundledInteger(Command command) {
		myCommand = command;
	}
	
	public BundledInteger(String variable, Map map) {
		myVariable = variable;
		myMap = map;
	}
	
	public Integer getInteger(){
		if(myCommand != null) return myCommand.execute();
		else if(myVariable != null) return (Integer) myMap.get(myVariable);
		else return myInteger;
	}

}
