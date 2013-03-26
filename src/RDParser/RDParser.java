package RDParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import model.Turtle;

public abstract class RDParser {
	private Map<String, Node> Grammar;
	private Turtle turtle;

	public RDParser() {
		Grammar = new LinkedHashMap<String, Node>();
		Grammar.put("+", new Addition());
		Grammar.put("[", new OpenBracket());
		Grammar.put("]", new CloseBracket());
		Grammar.put("Make", new Make(Grammar));
		Grammar.put("If", new If());
		// Grammar.put("Forward", new Forward(turtle));
		Grammar.put("Repeat", new Repeat());
		// setGrammar();
	}

	RDParser(Turtle turtleIn) {
		this();
		turtle = turtleIn;

	}

	public RDParser(Map<String, Node> in) {
		Grammar = in;
	}

	private void setGrammar() {
		// Grammar = subGrammar();
	}

	public void addToGrammar(String k, Node v) {
		Grammar.put(k, v);
	}

	// public void addToGrammar(String[] args) {
	// if (args.length == 2) {
	// addToGrammar(args[0], args[1]);
	// }
	// }

	public void removeFromGrammar(String k) {
		Grammar.remove(k);
	}

	public void removeFromGrammar(String[] Ks) {
		if (Ks.length > 0) {
			for (String k : Ks) {
				removeFromGrammar(k);
			}
		}
	}

	public Node parse(Scanner input) {
		if (input.hasNext()) {
			String nextStr = input.next();
			Node ret = generateNode(nextStr);
			return parse(input, ret);
		}
		return null;
	}

	public Node parse(Scanner input, Node nodeIn) {
		if (nodeIn.isLeaf()) {
			return nodeIn;
		}
		while (nodeIn.isNotFull() && input.hasNext()) {
			String nextStr = input.next();
			Node childNode = parse(input, generateNode(nextStr));
			nodeIn.addChild(childNode);
		}
		return nodeIn;
	}

	private Node generateNode(String in) {
		return null;
		// if(in.equals("+")){
		// return new Addition();
		// }
		// else if(in.equals("[")){
		// return new OpenBracket();
		// }
		// else if(in.equals("]")){
		// return new CloseBracket();
		// }
		// else if(in.equals("Make")){
		// return new Make(Grammar);
		// }
		// else if (in.equals("If")){
		// return new If();
		// }
		// else if (in.equals("Forward")){
		// return new Forward(turtle);
		// }
		// else if (in.equals("Repeat")){
		// return new Repeat();
		// }
		// if (Grammar.containsKey(in)){
		// return Grammar.get(in);
		// in.toLowerCase();
		// if(in.equals("+")){
		// return new Addition();
		// }
		// else if(in.equals("[")){
		// return new OpenBracket();
		// }
		// else if(in.equals("]")){
		// return new CloseBracket();
		// }
		// else if(in.equals("make")){
		// return new Make(Grammar);
		// }
		// else if (in.equals("if")){
		// return new If();
		// }
		// else if (in.equals("forward")){
		// return new Forward(turtle);
		// }
		// else if (in.equals("repeat")){
		// return new Repeat();
		// }
		// try
		// {
		// return new Leaf(Integer.parseInt(in));
		// }
		// catch(NumberFormatException nfe)
		// {
		// return new Leaf(in);
		// }
		//
	}

	public void printGrammar() {
		System.out.println(Grammar.entrySet());
	}

	abstract protected Map<String, Node> subGrammar();

}
