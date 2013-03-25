package RDParser;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements IExecute, IOperation{
	private List<Node> myChildren;
	private final String myType;
	
	public String toString(){
		return myType;
	}

	public Node(){
		this("NULL");
	}	
	
	public Node(String in){
		myType = in;
		myChildren = new ArrayList<Node>();
	}
	
	public String getType(){
		return myType;
	}
	
	public int getChildrenNumber(){
	
		return myChildren.size();
	}
	
	public boolean isNotFull(){
		return checkBounds(getChildrenNumber()+1);
	}
	
	public Value execute(){
		System.out.println("ME: " + this.toString());
		for (Node x : myChildren){
			System.out.println("   CHILD: "+ x.toString());
		}
		return operation(myChildren);
	}
	
	protected void addChild(Node in){
		if( checkChild(getChildrenNumber(), in) )
			myChildren.add(getChildrenNumber(), in);
	}
	
	protected void addChild(Node[] in) {
		if(in.length>0){
			for (Node x : in){
				addChild(x);
			}
		}
	}
	
//	protected void setChild(int idx, Node in){
//		if ( checkChild(idx, in) )
//			myChildren.add(idx, in);
//	}
//	
	
	public abstract boolean isLeaf();
	protected abstract boolean checkBounds(int length);
	protected abstract boolean checkChild(int length, Node in );
	
}
