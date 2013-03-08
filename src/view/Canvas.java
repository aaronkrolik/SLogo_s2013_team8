package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import model.SlogoModel;

public class Canvas extends JComponent {

	public static final int CANVAS_WIDTH = 660;
	public static final int CANVAS_HEIGHT = 530;
	public static final Dimension CANVAS_SIZE = new Dimension(CANVAS_WIDTH,
			CANVAS_HEIGHT);
	private static final long serialVersionUID = 1L;

	private SlogoModel myModel;

	/**
	 * Create a panel so that it knows its size
	 */
	public Canvas(SlogoModel model) {
		// set size (a bit of a pain)
		myModel = model;
		setPreferredSize(CANVAS_SIZE);
		setSize(CANVAS_SIZE);
		// prepare to receive input
		setFocusable(true);
		requestFocus();
	}

	/*
	 * The most important paint method for Canvas
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics pen) {
		pen.setColor(Color.white);
		pen.fillRect(5, 5, getSize().width, getSize().height);
		myModel.paint((Graphics2D) pen);
	}

	/*
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
}
