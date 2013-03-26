package RDParser;

import java.util.List;

public class Repeat extends BinaryNode {

	@Override
	public Value operation(List<Node> args) {
		Value ret = null;
		int counter = args.get(0).execute().getValue();
		Node exe = args.get(1);
		while (counter > 1) {
			ret = exe.execute();
			counter -= 1;
			System.out.println("counter! " + counter);
		}
		return ret;
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
