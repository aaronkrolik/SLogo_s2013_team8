package commands;

import java.util.List;
import java.util.Scanner;

import util.BundledInteger;
import util.BundledIntegerSequence;
import util.CommandSequence;
import util.Parser;
import util.ParsingInterface;
import util.StringSequence;

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
	
	public CommandSequence getCommandSequence(){
		return myParser.getNextCommandList(myLine);
	}
	
	public StringSequence getStringSequence(){
		return myParser.getNextStringList(myLine);
	}
	
	public BundledIntegerSequence getBundledIntSequence(){
		return myParser.getNextBundledIntList(myLine);
	}
	
	public void Reset(){
		myLine = new Scanner(myCopy);
	}
}
