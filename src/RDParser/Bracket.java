package RDParser;

import java.util.List;

public class Bracket extends Node{


	@Override
	protected boolean checkBounds(int length) {
		return true;
	}

	@Override
	protected boolean checkChild(int length, Node in) {
		return true;
	}

	@Override
	public Value operation(List<Node> args) {
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
}