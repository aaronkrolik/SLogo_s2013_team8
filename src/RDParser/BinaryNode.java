package RDParser;

public abstract class BinaryNode extends Node {

	public BinaryNode() {
		this("BinaryNode");
	}

	public BinaryNode(String in) {
		super(in);
	}

	protected boolean checkChild(int idx, Node in) {
		switch (idx) {
		case 0:
			return checkChild0(in);
		case 1:
			return checkChild1(in);
		}
		return false;
	}

	protected boolean checkBounds(int in) {
		return (in <= 2);
	}

	abstract boolean checkChild0(Node in);

	abstract boolean checkChild1(Node in);

}
