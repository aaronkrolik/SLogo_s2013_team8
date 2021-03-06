package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import model.*;
import view.*;

public class Controller implements IUpdatable {

	private List<SlogoModel> myModels;
	private List<Canvas> myCanvases;
	private List<SlogoGUI> myGUIs;
	private List<PrintWriter> myFiles;
	private Calendar myCal;
	private DateFormat myDateFormat;

	public Controller() {

		myModels = new ArrayList<SlogoModel>();
		myCanvases = new ArrayList<Canvas>();
		myGUIs = new ArrayList<SlogoGUI>();
		myFiles = new ArrayList<PrintWriter>();
		myDateFormat = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss");
		myCal = Calendar.getInstance();

		newGameSpace();
	}

	public void newGameSpace() {

		System.out.println();

		SlogoModel tempModel = newModel();
		// Canvas tempCanvas = newCanvas(tempModel);
		SlogoGUI tempGUI = newGUI(tempModel);
		// PrintWriter tempPW = newPW("SLOGO_"
		// + myDateFormat.format(myCal.getTime()) + ".txt");
		myModels.add(tempModel);
		// myCanvases.add(tempCanvas);
		myGUIs.add(tempGUI);
		// myFiles.add(tempPW);

	}

	private PrintWriter newPW(String fileNameIn) {
		try {
			return new PrintWriter(fileNameIn, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private SlogoModel newModel() {
		return new SlogoModel();
	}

	private SlogoGUI newGUI(SlogoModel in) {
		return new SlogoGUI(in, this);
	}

	private Canvas newCanvas(SlogoModel in) {
		return new Canvas(in);
	}

	public void update() {
		for (int i = 0; i < myModels.size(); i++) {
			String tmp = myGUIs.get(i).getInputText();
			// myFiles.get(i).println(tmp);
			try {
				myGUIs.get(i).DisplayReturn(myModels.get(i).update(tmp));
			} catch (Exception e) {
				myGUIs.get(i).DisplayException();
				e.printStackTrace();
			}
			myCanvases.get(i).repaint();
		}

	}

}
