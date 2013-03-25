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
		myTurtle.temptel;
		for ( int x : myTurtle.idCollections() ){
			myTurtle.tempTel(x)
			if( args.get(0).execute().getValue() == 1 )
				ret = args.get(1).execute();
		}
		return ret;
	}

}
