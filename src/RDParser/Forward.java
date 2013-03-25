package RDParser;

import java.util.List;

import model.Turtle;



public class Forward extends TurtleNode{
	private Turtle myTurtle;
	
	public Forward(Turtle turtle){
		
		myTurtle = turtle; 
	}
	
	public Forward(){
	}
	
	@Override
	public Value operation(List<Node> args) {
		Value temp = args.get(0).execute();
		System.out.println("going forward: "+ temp.getValue());
		myTurtle.forward(temp.getValue());
		return temp;
	}

}

