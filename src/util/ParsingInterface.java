package util;

import java.util.List;

import java.util.Scanner;

import commands.Command;

/**
 * Restricts the Command Input to only having access to the following commands
 * 
 * @author Jack Matteucci
 */

public interface ParsingInterface {

	public Command getNextCommand(Scanner line);

	public CommandSequence getNextCommandList(Scanner line);

	public BundledInteger getNextBundledInt(Scanner line);

	public BundledIntegerSequence getNextBundledIntList(Scanner line);

	public String getNextString(Scanner line);

	public StringSequence getNextStringList(Scanner line);

}
