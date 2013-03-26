package util;

import view.Canvas;
import model.Turtle;

/**
 * Allows the Turtle Commands to have access to the turtle
 * 
 * @author Jack Matteucci
 */

public interface ColorInterface extends ParsingInterface {

	public ColorController getColors();

	public Canvas getCanvas();
}
