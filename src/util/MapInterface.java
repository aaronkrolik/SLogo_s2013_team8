package util;

import java.util.Map;

/**
 * Inteface so that MapCommandInputs can have access to Parser Maps
 * 
 * @author Jack Matteucci
 */

public interface MapInterface extends ParsingInterface {

	public Map getCommandMap();

	public Map getVariableMap();

}
