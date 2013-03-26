package RDParser;

public class Value {
	private String myName;
	private int myValue;

	public Value(int val, String name) {
		myValue = val;
		myName = name;
	}

	public Value(int val) {
		this(val, "NULL");
	}

	public Value(String name) {
		this(-1, name);
	}

	public Value() {
		this(-1, "NULL");
	}

	public int getValue() {
		return myValue;
	}

	public String getName() {
		return myName;
	}

}
