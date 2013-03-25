package RDParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class RDParser {
	private Map<String, String> Grammar;

	public RDParser() {
		Grammar = new LinkedHashMap<String, String>();
		setGrammar();
	}

	public RDParser(Map<String, String> in) {
		Grammar = in;
	}

	private void setGrammar() {
		Grammar = subGrammar();
	}

	public void addToGrammar(String k, String v) {
		Grammar.put(k, v);
	}

	public void addToGrammar(String[] args) {
		if (args.length == 2) {
			addToGrammar(args[0], args[1]);
		}
	}

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

	public Node parse(Scanner input){
		if(input.hasNext()){
			String nextStr = input.next();
			Node ret = generateNode(nextStr);
			return parse(input, ret);
		}
		return null;
	}
	
	public Node parse(Scanner input, Node nodeIn) {
		if (nodeIn.isLeaf()){
			return nodeIn;
		}
		while (nodeIn.isNotFull() && input.hasNext()) { 
			String nextStr = input.next();
			Node childNode = parse(input, generateNode(nextStr));
			nodeIn.addChild(childNode);
		}
		return nodeIn;
	}

	private Node generateNode(String in){
		if(in.equals("+")){
			return new Addition();
		}
		else if(in.equals("[")){
			return new OpenBracket();
		}
		else if(in.equals("]")){
			return new CloseBracket();
		}
		else if(in.equals("Make")){
			return new Make(Grammar);
		}
		else if (in.equals("If")){
			return new If();
		}
		try  
		  {  
			return new Leaf(Integer.parseInt(in));  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return new Leaf(in);  
		  }  
		
	}
	
	public void printGrammar(){
		System.out.println(Grammar.entrySet());
	}

	abstract protected Map<String, String> subGrammar();
	
}
