package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import model.*;
import view.*;



public class Controller implements IUpdatable {
	
	private List<SlogoModel> myModels;
	private List<Canvas> myCanvases;
	private List<SlogoGUI> myGUIs;
	
	public Controller () {
		
		myModels 	= new ArrayList <SlogoModel> ();
		myCanvases 	= new ArrayList	<Canvas> 	 ();
		myGUIs 		= new ArrayList	<SlogoGUI> 	 (); 
		
		newGameSpace ();
	}
	
	public void newGameSpace () {
		
		SlogoModel	tempModel	= newModel ();
		Canvas		tempCanvas	= newCanvas (tempModel);
		SlogoGUI 	tempGUI		= newGUI (tempModel, tempCanvas);
		
		myModels	.add(tempModel);
		myCanvases	.add( newCanvas(tempModel) );
		myGUIs		.add( tempGUI );
		
		
		JFrame frame = new JFrame("SLOGO");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tempGUI);
		frame.setVisible(true);
		
	}
	
	private SlogoModel newModel () {
		return new SlogoModel ();	
	}
	
	private SlogoGUI newGUI (SlogoModel in, Canvas inCanvas) {
		return new SlogoGUI (in, inCanvas, this);
	}
	
	private Canvas newCanvas (SlogoModel in) {
		return new Canvas (in);
	}
	
	public void update () {
		for (int i = 0; i < myModels.size(); i++) {
			
			String tmp = myGUIs.get(i).getAndResetInputText();
			System.out.println(tmp);
			myModels.get(i).update(tmp);
			myCanvases.get(i).repaint();
		}
		
	}
	
	

}
