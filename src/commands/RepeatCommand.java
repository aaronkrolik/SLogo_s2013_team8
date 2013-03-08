package commands;

import java.util.List;
import java.util.Scanner;

import util.BundledInteger;
import util.ParsingInterface;

public class RepeatCommand extends Command {
	private BundledInteger myTimes;
	List<Command> myCommandList;
	
	public RepeatCommand(CommandInput input) {
		super(input);
		myTimes = input.getBundledInt();
		myCommandList = input.getCommandList();
	}

	public RepeatCommand() {
	}

	@Override
	public Integer execute() {
		System.out.println(myCommandList);
		System.out.println(myTimes);
		Integer myReturn = 0;
		for(int i = 0; i<myTimes.getInteger(); i++){
			for(Command c: myCommandList){
				myReturn = c.execute();
			}
		}
		return myReturn;
	}

	@Override
	public Command createCommand(ParsingInterface parser, Scanner line){
		return new RepeatCommand(super.createCommandInput(parser, line));
	}

}
