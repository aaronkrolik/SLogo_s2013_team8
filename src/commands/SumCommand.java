package commands;

public class SumCommand extends Command {
	private Integer myFirst;
	private Integer mySecond;
	
	public SumCommand(CommandInput input) {
		super(input);
		myFirst = super.getInput().getInt();
		mySecond = super.getInput().getInt();
	}
	@Override
	public Integer execute() {
		return myFirst + mySecond ;
	}

}
