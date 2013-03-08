package util;

import java.util.ArrayList;
import java.util.List;

public class BundledIntegerSequence {
	List<BundledInteger> myBundledIntegerList;
	
	public BundledIntegerSequence() {
		List<BundledInteger> myBundledIntegerList = new ArrayList<BundledInteger>();
	}
	
	public List<BundledInteger> getBundledIntegerList(){
		return myBundledIntegerList;
	}

}
