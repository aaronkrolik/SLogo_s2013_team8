package RDParser;

import java.util.List;
import java.util.Map;

public class Make extends BinaryNode{
	Map<String, Node> grammar;
	
	public Make (Map<String, Node> map){
		super("MAKE");
		grammar = map;
	}

	@Override
	public Value operation(List<Node> args) {
		Value k = args.get(0).execute();
		Value v = args.get(1).execute();
		grammar.put(k.getName(), args.get(1));
		return v;
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
