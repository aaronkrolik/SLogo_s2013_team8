package RDParser;

import java.util.List;
import model.Turtle;

public abstract class TurtleNode extends Node{

	
	public TurtleNode(){
		super();
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	public String toString(){
		return "turtleNode";
	}

	@Override
	protected boolean checkBounds(int length) {
		System.out.println(this.toString() + getChildrenNumber());
		return true;
	}

	@Override
	protected boolean checkChild(int length, Node in) {
		return true;
	}
	

}
