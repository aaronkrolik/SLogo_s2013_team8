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
		
		for ( int x : myTurtle.IdCollection() ){
			myTurtle.temperarytell(x);
			if( args.get(0).execute().getValue() == 1 )
				ret = args.get(1).execute();
		}
		return ret;
	}

}
