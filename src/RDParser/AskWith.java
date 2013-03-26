package RDParser;

import java.util.List;

import model.Turtle;

public class AskWith extends TurtleNode{
	private Turtle myTurtle;
	
	public AskWith(Turtle turtle){
		myTurtle = turtle;
	}
	
	@Override
	public Value operation(List<Node> args) {
		Value ret = null;
<<<<<<< HEAD
		for ( int x : myTurtle.IdCollection()){
=======
		
		for ( int x : myTurtle.IdCollection() ){
>>>>>>> ea77ad2b01e771bb52e28887cc326e35339b69fa
			myTurtle.temperarytell(x);
			if( args.get(0).execute().getValue() == 1 )
				ret = args.get(1).execute();
		}
		return ret;
	}

}
