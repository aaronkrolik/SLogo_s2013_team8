package util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorController {

	Map<Integer, Color> myMap;
	public ColorController() {
		myMap = new HashMap<Integer, Color>();
	}
	
	public Map<Integer, Color> getMap(){
		return myMap;
	}
	
	public void put(int index, int r, int g, int b){
		myMap.put(index, RGBtoColor(r,g,b));
	}
	
	public Color get(int index){
		return myMap.get(index);
	}
	
	public static Color RGBtoColor(int r, int g, int b){
		float[] hsb = new float[2];
		Color.RGBtoHSB(r, g, b, hsb);
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}

}
