package util;

import model.Turtle;

/**
 * Allows the Turtle Commands to have access to the turtle
 * 
 * @author Jack Matteucci
 */

public interface TurtleInterface extends ParsingInterface {

	public Turtle getTurtle();
}
