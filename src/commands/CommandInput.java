package commands;

import java.util.List;
import java.util.Scanner;

/**
 * Mediates Commands grabbing information from the Parser.  Restricts access to
 * the Parser, but also provides necessary information Commands via its commands
 * 
 * @author Jack Matteucci
 */

import util.BundledInteger;
import util.BundledIntegerSequence;
import util.CommandSequence;
import util.Parser;
import util.ParsingInterface;
import util.StringSequence;
import util.Exceptions.ExpectedInput;

import model.SlogoModel;

public class CommandInput {
	ParsingInterface myParser;
	Scanner myLine;
	String myCopy;

	public CommandInput(ParsingInterface parser, Scanner line) {
		myParser = parser;
		myLine = line;
	}

	/**
	 * return the next String from a Scanner
	 * @throws ExpectedInput 
	 */
	public String getString() throws ExpectedInput {
		return myParser.getNextString(myLine);
	}

	/**
	 * return the next BundledInteger from a Scanner
	 */
	public BundledInteger getBundledInt() throws ExpectedInput {
		return myParser.getNextBundledInt(myLine);
	}

	/**
	 * return the next Command Sequence from a Scanner
	 */
	public List<Command> getCommandList() throws ExpectedInput {
		return myParser.getNextCommandList(myLine);
	}

	/**
	 * return the next StringSequence from a Scanner
	 */
	public List<String> getStringList() throws ExpectedInput {
		return myParser.getNextStringList(myLine);
	}

	/**
	 * return the next BundledInt Sequence from a Scanner
	 */
	public List<BundledInteger> getBundledIntList() throws ExpectedInput {
		return myParser.getNextBundledIntList(myLine);
	}

}
