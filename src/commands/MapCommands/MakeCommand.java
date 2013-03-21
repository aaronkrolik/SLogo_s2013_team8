package commands.MapCommands;

import java.util.Scanner;

import commands.Command;
import commands.RepeatCommand;

import util.BundledInteger;
import util.ParsingInterface;
import util.Exceptions.ExpectedInput;

/**
 * The Make Command
 * 
 * @author Jack Matteucci
 */

public class MakeCommand extends MapCommand {
	private final static String VARIABLE_TAG = ":";

	private String myName;
	private BundledInteger myValue;

	public MakeCommand(MapCommandInput input) throws ExpectedInput {
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
	public Command createCommand(ParsingInterface parser, Scanner line) throws ExpectedInput {
		return new MakeCommand((MapCommandInput) super.createCommandInput(
				parser, line));
	}

}
