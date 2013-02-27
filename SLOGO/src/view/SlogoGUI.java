package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.SlogoModel;
import javax.swing.JButton;
import javax.swing.JSeparator;


public class SlogoGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int NO_KEY_PRESSED = -1;
	
	private JTextField myInputTextField;
	private JButton myEnter;
	private ActionListener takeInputAfterClickingButton;
	private KeyListener enterKeyListener;
	private JSeparator mySeparator;
	private Canvas myCanvas;
	private SlogoModel myModel;
    private int myLastKeyPressed;

	/**
	 * Create the View.
	 */
	public SlogoGUI(SlogoModel model) {
		myModel = model;
		setLayout(null);
		add(createInputTextFieldAndSetItsProperties());
		add(createEnterButtonAndSetItsProperties());
		add(createSeparator());
		add(createCanvas());
	}

	private Canvas createCanvas() {
		myCanvas = new Canvas(myModel);
		return myCanvas;
	}


	private JSeparator createSeparator() {
		mySeparator = new JSeparator();
		mySeparator.setBounds(0, 536, 800, 12);
		return mySeparator;
	}


	private JButton createEnterButtonAndSetItsProperties() {
		myEnter = new JButton("Enter");
		myEnter.setBounds(663, 547, 64, 26);
		createButtonActionListenerAndSetItsProperties();
		myEnter.addActionListener(takeInputAfterClickingButton);
		return myEnter;
	}

	// Action Listener Here
	private void createButtonActionListenerAndSetItsProperties() {
		takeInputAfterClickingButton = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				update();
			}
		};
	}
	
	private void update() {
		String input = myInputTextField.getText().toString();
		myModel.update(input);
		myCanvas.repaint();
		myInputTextField.setText("");
	}

	private JTextField createInputTextFieldAndSetItsProperties() {
		myInputTextField = new JTextField();
		myInputTextField.setBounds(6, 545, 657, 27);
		myInputTextField.setColumns(10);
		createKeyEventListener();
		myInputTextField.addKeyListener(enterKeyListener);
		return myInputTextField;
	}
	
	private void createKeyEventListener(){
		enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                myLastKeyPressed = e.getKeyCode();
                if (myLastKeyPressed == KeyEvent.VK_ENTER){
                	update();
                }
            }
            @Override
            public void keyReleased (KeyEvent e) {
                myLastKeyPressed = NO_KEY_PRESSED;
            }
		};
	}
	private int getMyLastKeyPressed(){
		return myLastKeyPressed;
	}
}
