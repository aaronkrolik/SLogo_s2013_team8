package RDParser;

import java.util.HashMap;
import java.util.Map;

import model.Turtle;

public class RDParserSLogo extends RDParser {

	public RDParserSLogo(Turtle turtle) {
		super(turtle);
	}

	public RDParserSLogo() {
		this(new Turtle());
	}

	public RDParserSLogo(Map<String, Node> in) {
		super(in);
	}

	@Override
	protected Map<String, Node> subGrammar() {
		Map<String, Node> grammar = new HashMap<String, Node>();
		return grammar;
	}

}
