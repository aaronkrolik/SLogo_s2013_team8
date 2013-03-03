package commands;

import java.util.List;

public class RepeatCommand extends Command {
	int myTimes;
	List<Command> myCommandList;
	
	
	public RepeatCommand(CommandInput input) {
		super(input);
		myTimes = super.getInput().getInt();
		myCommandList = super.getInput().getCommandList();
	}

	@Override
	public Integer execute() {
		System.out.println(myCommandList);
		System.out.println(myTimes);
		Integer myReturn = 0;
		for(int i = 0; i<myTimes; i++){
			for(Command c: myCommandList){
				myReturn = c.execute();
			}
		}
		return myReturn;
	}

}
