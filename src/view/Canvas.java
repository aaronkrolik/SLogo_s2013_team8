package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;

import javax.swing.JComponent;

import util.Pixmap;

import model.SlogoModel;

/**
 * Canvas sets up the background on which the turtle moves. Canvas is
 * responsible for the background color and for turning on and off the grid.
 * 
 * @author David Liu and Bill Muensterman
 * 
 */

public class Canvas extends JComponent {

	public static final int CANVAS_WIDTH = 660;
	public static final int CANVAS_HEIGHT = 530;
	public static final Dimension CANVAS_SIZE = new Dimension(CANVAS_WIDTH,
			CANVAS_HEIGHT);
	private static final long serialVersionUID = 1L;

	private SlogoModel myModel;
	private Grid myGrid;
	private boolean gridOn = false;
	private Color myBackgroundColor;
	private Pixmap myBackground;

	/**
	 * Create a panel so that it knows its size
	 * 
	 * @param model
	 */
	public Canvas(SlogoModel model) {
		// set size (a bit of a pain)
		myModel = model;
		myBackgroundColor = Color.white;
		setPreferredSize(CANVAS_SIZE);
		setSize(CANVAS_SIZE);
		// prepare to receive input
		setFocusable(true);
		requestFocus();
		myGrid = new Grid(this);
	}

	/*
	 * The most important paint method for Canvas
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	/**
	 * Create a rectangle the color of the background to fill the view. Paint
	 * grid lines if they are turned on.
	 */
	@Override
	public void paintComponent(Graphics pen) {
		System.out.println("in Canavs");
		pen.setColor(myBackgroundColor);
		pen.fillRect(5, 5, CANVAS_WIDTH, CANVAS_HEIGHT);
		if (gridOn)
			myGrid.paint((Graphics2D) pen);
		myModel.paint((Graphics2D) pen);

	}

	/**
	 * Turn grid on
	 */
	public void turnOnGrid() {
		gridOn = true;
		repaint();
	}

	/**
	 * Turn grid off
	 */
	public void turnOffGrid() {
		gridOn = false;
		repaint();
	}

	/**
	 * Return dimensional information about the Canvas
	 */
	public int width() {
		return CANVAS_WIDTH;
	}

	public int height() {
		return CANVAS_HEIGHT;
	}

	public Dimension size() {
		return CANVAS_SIZE;
	}

	/**
	 * Return the color of the background
	 */
	public Color myBackgroundColor() {
		return myBackgroundColor;
	}

	/**
	 * Change the color of the background
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		myBackgroundColor = color;
	}
}
