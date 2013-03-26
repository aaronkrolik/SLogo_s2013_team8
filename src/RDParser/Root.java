package RDParser;

import java.util.List;

public class Root extends Node {

	@Override
	public Value operation(List<Node> args) {
		return args.get(0).execute();
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	protected boolean checkBounds(int length) {
		return (length <= 1);
	}

	@Override
	protected boolean checkChild(int length, Node in) {
		return true;
	}

}
