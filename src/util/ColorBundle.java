package util;

public class ColorBundle {

	int myRed;
	int myGreen;
	int myBlue;
	
	public ColorBundle(int r, int b, int g) {
		myRed = r;
		myBlue = b;
		myGreen = g;
	}

	public int getRed(){
		return myRed;
	}
	public int getBlue(){
		return myBlue;
	}
	public int getGreen(){
		return myGreen;
	}
}
