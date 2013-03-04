package commands;

import java.util.List;
import java.util.Scanner;

import util.BundledInteger;
import util.Parser;
import util.ParsingInterface;

import model.SlogoModel;

public class CommandInput {
	ParsingInterface myParser;
	Scanner myLine;
	String myCopy;
	
	public CommandInput(ParsingInterface parser, Scanner line) {
		myParser =  parser;
		myLine = line;
	}
	
	public Scanner getScanner(){
		return myLine;
	}
	
	public String getString(){
		return myParser.getNextString(myLine);
	}
	
	public BundledInteger getBundledInt(){
		return myParser.getNextBundledInt(myLine);
	}
	
	public List<Command> getCommandList(){
		return myParser.getNextCommandList(myLine);
	}
	
	public List<String> getStringList(){
		return myParser.getNextStringList(myLine);
	}
	
	public List<BundledInteger> getBundledIntList(){
		return myParser.getNextIntegerList(myLine);
	}
	
	public void Reset(){
		myLine = new Scanner(myCopy);
	}
}
