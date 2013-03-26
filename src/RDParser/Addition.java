package RDParser;

import java.util.List;

public class Addition extends BinaryNode {

	@Override
	public Value operation(List<Node> args) {
		int temp = 0;
		for (Node x : args) {
			Value tempVal = x.execute();
			temp += tempVal.getValue();
		}
		return new Value(temp, "NUMBER");
	}

	@Override
	protected boolean checkChild(int idx, Node in) {
		return true;
	}

	protected boolean checkBounds(int in) {
		return in <= 2;
	}

	public String toString() {
		return "Addition";
	}

	@Override
	boolean checkChild0(Node in) {
		return true;
	}

	@Override
	boolean checkChild1(Node in) {
		return checkChild0(in);
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
