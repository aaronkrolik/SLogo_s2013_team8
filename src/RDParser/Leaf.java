package RDParser;

import java.util.List;

public class Leaf extends Node {
	private Value myValue;

	public String toString() {
		return Integer.toString(myValue.getValue());
	}

	public Leaf(int intIn, String strIn) {
		myValue = new Value(intIn, strIn);
	}

	public Leaf(int intIn) {
		this(intIn, "NULL");
	}

	public Leaf(String strIn) {
		this(-1, strIn);
	}

	public Leaf() {
		this(-1, "NULL");
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	protected boolean checkBounds(int length) {
		return false;
	}

	@Override
	protected boolean checkChild(int length, Node in) {
		return false;
	}

	@Override
	public Value operation(List<Node> args) {
		return myValue;
	}

}
