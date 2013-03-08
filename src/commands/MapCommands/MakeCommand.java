package commands.MapCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;

/**
 * The Make Command
 * 
 * @author Jack Matteucci
 */

public class MakeCommand extends MapCommand {
	private final static String VARIABLE_TAG = ":";

	private String myName;
	private BundledInteger myValue;

	public MakeCommand(MapCommandInput input) {
		super(input);
		myName = VARIABLE_TAG + input.getString();
		myValue = input.getBundledInt();
	}

	public MakeCommand() {
	}

	@Override
	public Integer execute() {
		Integer value = myValue.getInteger();
		super.getVariableMap().put(myName, value);
		return value;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line) {
		return new MakeCommand((MapCommandInput) super.createCommandInput(
				parser, line));
	}

}
