package util;


	import java.awt.Color;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;

	public class ShapeController {

		Map<Integer, Shape> myMap;
		public ShapeController() {
			myMap = new HashMap<Integer, Shape>();
		}
		
		public Map<Integer, Shape> getMap(){
			return myMap;
		}

		
		public void put(int index, Shape a){
			myMap.put(index, a);
		}
		
		public Shape get(int index){
			return myMap.get(index);
		}
		
}
