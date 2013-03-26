package RDParser;

import java.util.List;

public class OpenBracket extends Node {
	private boolean notComplete = true;

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
		return notComplete;
	}

	@Override
	protected boolean checkChild(int length, Node in) {
		if (in instanceof CloseBracket)
			notComplete = false;
		return true;
	}

}
