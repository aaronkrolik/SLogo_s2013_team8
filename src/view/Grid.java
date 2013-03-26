package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Grid extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int OFFSET = 5;
	private int myWidth, myHeight, originX, originY;

	/**
	 * 
	 */
	public Grid(Canvas canvas) {
		myWidth = canvas.getWidth();
		myHeight = canvas.getHeight();
		originX = OFFSET + myWidth / 2;
		originY = OFFSET + myHeight / 2;
	}

	public void paint(Graphics2D pen) {
		System.out.println("in Grid");
		System.out.println("origin is: (" + originX + "," + originY + ") ");
		drawHorizontalGrid(pen);
		drawVerticalGrid(pen);
		System.out.println("finish drawing Grid");
	}

	public void drawHorizontalGrid(Graphics2D pen) {
		System.out.println("drawing Grid");
		for (int y = originY; y >= 0; y = y - 100) {
			for (int x = OFFSET; x <= myWidth; x = x + 20) {
				System.out.println("drawing Grid");
				drawHorizontalDashedLine(pen, x, x + 15, y);
			}
		}

		for (int y = originY; y <= myHeight; y = y + 100) {
			for (int x = OFFSET; x <= myWidth; x = x + 20) {
				System.out.println("drawing Grid");
				drawHorizontalDashedLine(pen, x, x + 15, y);
			}
		}
	}

	public void drawVerticalGrid(Graphics2D pen) {
		for (int x = originX; x >= 0; x = x - 100) {
			for (int y = OFFSET; y <= myHeight; y = y + 20) {
				System.out.println("drawing Grid");
				drawVerticalDashedLine(pen, y, y + 15, x);
			}
		}

		for (int x = originX; x <= myWidth; x = x + 100) {
			for (int y = OFFSET; y <= myHeight; y = y + 20) {
				System.out.println("drawing Grid");
				drawVerticalDashedLine(pen, y, y + 15, x);
			}
		}
	}

	public void drawHorizontalDashedLine(Graphics2D pen, int startX, int endX,
			int Y) {
		pen.setColor(Color.BLACK);
		System.out.println("Actually drawing Grid");
		pen.drawLine(startX, Y, endX, Y);
	}

	public void drawVerticalDashedLine(Graphics2D pen, int startY, int endY,
			int X) {
		pen.setColor(Color.BLACK);
		System.out.println("Actually drawing Grid");
		pen.drawLine(X, startY, X, endY);
	}

}
