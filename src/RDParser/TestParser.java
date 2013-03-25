package RDParser;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TestParser {
	
	public static void main(String[] args){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		//String testStr = "If + 1 1 Make foo + + 50 60 70";
		String testStr = "Repeat 3 [ + 50 50 ]";
		Scanner testScanner = new Scanner(testStr);
		RDParser parser = new RDParserSLogo();
		Node root = parser.parse(testScanner);
		Value x = root.execute();
		System.out.println(x.getValue());
		parser.printGrammar();
		return;

	}

}
