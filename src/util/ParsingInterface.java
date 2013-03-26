package util;

import java.util.List;

import java.util.Scanner;

import util.Exceptions.ExpectedInput;

import commands.Command;

/**
 * Restricts the Command Input to only having access to the following commands
 * 
 * @author Jack Matteucci
 */

public interface ParsingInterface {

	public Command getNextCommand(Scanner line) throws ExpectedInput;

	public List<Command> getNextCommandList(Scanner line) throws ExpectedInput;

	public BundledInteger getNextBundledInt(Scanner line) throws ExpectedInput;

	public List<BundledInteger> getNextBundledIntList(Scanner line)
			throws ExpectedInput;

	public String getNextString(Scanner line) throws ExpectedInput;

	public List<String> getNextStringList(Scanner line) throws ExpectedInput;

}
