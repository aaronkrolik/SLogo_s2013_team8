package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Houses The Bundeled int List
 * 
 * @author Jack Matteucci
 */

public class BundledIntegerSequence {
	List<BundledInteger> myBundledIntegerList;

	public BundledIntegerSequence() {
		myBundledIntegerList = new ArrayList<BundledInteger>();
	}

	public List<BundledInteger> getBundledIntegerList() {
		return myBundledIntegerList;
	}
	
	public void setBundledIntegerList(List<BundledInteger> list ) {
		myBundledIntegerList = list;
	}

}
