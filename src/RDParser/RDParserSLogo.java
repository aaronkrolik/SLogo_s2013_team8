package RDParser;

import java.util.HashMap;
import java.util.Map;

public class RDParserSLogo extends RDParser{
	
	public RDParserSLogo(){
		super();
	}
	
	public RDParserSLogo(Map<String, String> in){
		super(in);
	}
	
	@Override
	protected Map<String, String> subGrammar() {
		Map<String, String> grammar = new HashMap<String, String>();
		grammar.put("FORWARD", "FORWARD");
		return grammar;
	}

	
}
