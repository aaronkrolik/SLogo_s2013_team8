package util;

import java.util.List;
import java.util.Scanner;

import commands.Command;

public interface ParsingInterface {

	
	public Command getNextCommand(Scanner line);
	
	public List<Command> getNextCommandList(Scanner line);
	
	public BundledInteger getNextBundledInt(Scanner line);
	
	public List<BundledInteger> getNextIntegerList(Scanner line);
	
	public String getNextString(Scanner line);
	
	public List<String> getNextStringList(Scanner line);


}
