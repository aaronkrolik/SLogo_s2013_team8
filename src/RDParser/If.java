package RDParser;

import java.util.List;

public class If extends BinaryNode{

	public If (){
		super("If");
	}
	
	@Override
	public Value operation(List<Node> args) {
		//System.out.println("print " + args.get(0));
		return (args.get(0).execute().getValue()==0) ? new Value(0) : args.get(1).execute();
	}

	@Override
	boolean checkChild0(Node in) {
		return true;
	}

	@Override
	boolean checkChild1(Node in) {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
