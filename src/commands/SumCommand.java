package commands;

import util.BundledInteger;

public class SumCommand extends Command {
	private BundledInteger myFirst;
	private BundledInteger mySecond;
	
	public SumCommand(CommandInput input) {
		super(input);
		myFirst = input.getBundledInt();
		mySecond = input.getBundledInt();
	}
	@Override
	public Integer execute() {
	System.out.println(myFirst.getInteger());
	System.out.println(mySecond.getInteger());
		return myFirst.getInteger() + mySecond.getInteger() ;
	}

}
